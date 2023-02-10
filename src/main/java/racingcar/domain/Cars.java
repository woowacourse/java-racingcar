package racingcar.domain;

import static racingcar.messsages.ExceptionMessage.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
	private static final int CARS_MIN_SIZE = 2;
	private final Set<Car> cars = new LinkedHashSet<>();

	public void generateCars(CarMovement carMovement, List<String> carNames) {
		cars.clear();
		validateCarsSizeOneOrZero(carNames);
		carNames.forEach(carName -> generateCar(carMovement, carName));
	}

	public List<String> findWinnerNames() {
		final int maxPosition = cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(() -> new IllegalStateException(CARS_EMPTY_EXCEPTION.getMessage()));

		return cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toUnmodifiableList());
	}

	public void moveCars() {
		cars.forEach(Car::move);
	}

	public Set<Car> getCars() {
		return Collections.unmodifiableSet(cars);
	}

	private void generateCar(final CarMovement carMovement, final String name) {
		final Car newCar = new Car(carMovement, name);
		validateDuplicatedCarName(newCar);
		cars.add(newCar);
	}

	private void validateCarsSizeOneOrZero(final List<String> carNames) {
		if (carNames.size() < CARS_MIN_SIZE) {
			throw new IllegalArgumentException(CARS_SIZE_EXCEPTION.getMessage());
		}
	}

	private void validateDuplicatedCarName(final Car newCar) {
		if (cars.contains(newCar)) {
			throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
		}
	}
}
