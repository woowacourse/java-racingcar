package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final int MINIMUM_NUMBER_OF_CARS = 2;
	private static final int INITIAL_MAX_POSITION = 0;

	private final List<Car> cars = new ArrayList<>();

	public Cars(final List<String> carsName) {
		validateCarsName(carsName);
		carsName.forEach(carName -> cars.add(new Car(carName)));
	}

	private void validateCarsName(List<String> carsName) {
		validateNullCarsName(carsName);
		validateDuplicateCarName(carsName);
		validateNumberOfCars(carsName);
	}

	private void validateNullCarsName(List<String> carsName) {
		if (carsName == null) {
			throw new IllegalArgumentException("carsName이 null일 수 없습니다.");
		}
	}

	private void validateDuplicateCarName(List<String> carsName) {
		boolean isDuplicatedName = !(carsName.stream()
			.allMatch(new HashSet<>()::add));

		if (isDuplicatedName) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다.");
		}
	}

	private void validateNumberOfCars(List<String> carsName) {
		if (carsName.size() < MINIMUM_NUMBER_OF_CARS) {
			throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
		}
	}

	public void moveAll() {
		cars.forEach(car -> car.move(RandomGenerator.generateRandom()));
	}

	public int findMaxPosition() {
		int maxPosition = INITIAL_MAX_POSITION;

		for (Car nextCar : cars) {
			maxPosition = nextCar.maxPosition(maxPosition);
		}

		return maxPosition;
	}

	public List<String> getWinnersName(int maxPosition) {
		return cars.stream()
			.filter(car -> car.isMaxPosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return cars;
	}
}
