package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final int MINIMUM_NUMBER_OF_CARS = 2;
	private static final String COMMA_DELIMITER = ", ";
	private static final String NEW_LINE_DELIMITER = "\n";

	private final List<Car> cars = new ArrayList<>();

	public Cars(List<String> carsName) {
		validateDuplicateCarName(carsName);
		validateNumberOfCars(carsName);

		carsName.forEach(carName -> cars.add(new Car(carName)));
	}

	private void validateDuplicateCarName(List<String> carsName) {
		if (!carsName.stream()
				.allMatch(new HashSet<>()::add)) {
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

	public int getMaxPosition(int currentMaxPosition) {
		for (Car nextCar : cars) {
			currentMaxPosition = nextCar.compareMaxPosition(currentMaxPosition);
		}

		return currentMaxPosition;
	}

	public String getWinnersName(int maxPosition) {
		return cars.stream()
				.filter(car -> car.isMaxPosition(maxPosition))
				.map(Car::getName)
				.collect(Collectors.joining(COMMA_DELIMITER));
	}

	public String getCurrentPosition() {
		return cars.stream()
				.map(Car::toString)
				.collect(Collectors.joining(NEW_LINE_DELIMITER));
	}
}
