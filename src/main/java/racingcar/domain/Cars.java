package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final int MINIMUM_NUMBER_OF_CARS = 2;

	private final List<Car> cars;

	public Cars(List<String> carsName) {
		validateDuplicateCarName(carsName);
		validateNumberOfCars(carsName);

		List<Car> cars = new ArrayList<>();
		carsName.forEach(carName -> cars.add(new Car(carName)));
		this.cars = Collections.unmodifiableList(cars);
	}

	private void validateDuplicateCarName(List<String> carsName) {
		if (carsName.stream()
				.distinct()
				.count() != carsName.size()) {
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

	public List<Car> getWinners() {
		return cars.stream()
				.filter(car -> car.isMaxPosition(getMaxPosition()))
				.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		int maxPosition = Car.INITIAL_POSITION;
		for (Car car : cars) {
			maxPosition = car.getBiggerPosition(maxPosition);
		}

		return maxPosition;
	}

	public List<Car> getCars() {
		return cars;
	}
}
