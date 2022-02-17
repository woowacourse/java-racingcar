package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
	private static final String ERROR_CAR_NAMES_DUPLICATE_MESSAGE = "중복된 자동차 이름이 입력됐습니다.";

	private final List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public void createCars(String[] carNames) {
		cars.clear();
		checkDuplicationCarNames(carNames);
		Arrays.stream(carNames)
			.forEach(carName -> cars.add(new Car(carName)));
	}

	public void move(List<Integer> randoms) {
		IntStream.range(0, randoms.size())
			.forEach(i -> cars.get(i).move(randoms.get(i)));
	}

	public int getSize() {
		return cars.size();
	}

	public List<CarDto> getCars() {
		return carsToCarDtos(cars);
	}

	public List<CarDto> getWinners() {
		List<Car> winnerCars = cars.stream()
			.filter(car -> car.isSamePosition(maxPosition()))
			.collect(Collectors.toList());
		return carsToCarDtos(winnerCars);
	}

	private List<CarDto> carsToCarDtos(List<Car> cars) {
		return cars.stream()
			.map(CarDto::new)
			.collect(Collectors.toList());
	}

	private int maxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = car.getBiggerPosition(maxPosition);
		}
		return maxPosition;
	}

	private void checkDuplicationCarNames(String[] carNames) {
		Set<String> duplicationCheck = new HashSet<>(Arrays.asList(carNames));
		if (duplicationCheck.size() != carNames.length) {
			throw new IllegalArgumentException(ERROR_CAR_NAMES_DUPLICATE_MESSAGE);
		}
	}
}
