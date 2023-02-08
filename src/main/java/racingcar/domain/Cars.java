package racingcar.domain;

import static racingcar.exception.ErrorMessages.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	private final Set<Car> cars = new LinkedHashSet<>();

	public void generateCars(List<String> carNames) {
		validateCarsSizeOneOrZero(carNames);
		for (String carName : carNames) {
			generateCar(carName);
		}
	}

	public void moveCars() {
		cars.forEach(Car::move);
	}

	public List<String> findWinnerNames() {
		List<String> winnerNames = new ArrayList<>();
		int maxPosition = 0;
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winnerNames.add(car.getName());
			}
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
				winnerNames.clear();
				winnerNames.add(car.getName());
			}
		}
		return winnerNames;
	}

	public Set<Car> getCars() {
		return Collections.unmodifiableSet(cars);
	}

	private void generateCar(String name) {
		Car newCar = new Car(name);
		validateDuplicatedCarName(newCar);
		cars.add(newCar);
	}

	private void validateCarsSizeOneOrZero(List<String> carNames) {
		int carsSize = carNames.size();
		if (carsSize == 0 || carsSize == 1) {
			throw new IllegalArgumentException(CARS_SIZE_EXCEPTION.getMessage());
		}
	}

	private void validateDuplicatedCarName(Car newCar) {
		if (cars.contains(newCar)) {
			throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
		}
	}
}
