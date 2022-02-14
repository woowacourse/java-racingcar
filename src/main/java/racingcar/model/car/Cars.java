package racingcar.model.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.dto.CarDto;
import racingcar.util.RandomUtil;

public class Cars {
	private static final int MIN_RANDOM_BOUND = 0;
	private static final int MAX_RANDOM_BOUND = 9;
	private static final int MIN_MOVABLE_VALUE = 4;

	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars create() {
		return new Cars(new ArrayList<>());
	}

	public void add(Car car) {
		if (cars.contains(car)) {
			cars.clear();
			throw new IllegalArgumentException("이미 존재하는 자동차 이름입니다.");
		}

		cars.add(car);
	}

	public void race(RandomUtil randomUtil) {
		cars.stream()
			.filter(i -> randomUtil.createRandom(MIN_RANDOM_BOUND, MAX_RANDOM_BOUND) >= MIN_MOVABLE_VALUE)
			.forEach(Car::move);
	}

	public List<String> getWinnersNames() {
		return getWinners().stream()
			.map(Car::toDto)
			.map(CarDto::getName)
			.collect(Collectors.toList());
	}

	private List<Car> getWinners() {
		return getCarsByPosition(getFirstPosition());
	}

	public List<Car> getCarsByPosition(Position position) {
		return cars.stream()
			.filter((car) -> car.getPosition().equals(position))
			.collect(Collectors.toList());
	}

	public Position getFirstPosition() {
		if (cars.isEmpty()) {
			throw new IllegalArgumentException("아무 차량도 추가되지 않았습니다.");
		}
		Collections.sort(cars);
		return cars.get(0).getPosition();
	}

	public List<CarDto> getCarsDto() {
		return cars.stream()
			.map(Car::toDto)
			.collect(Collectors.toList());
	}
}
