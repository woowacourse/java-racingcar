package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	private final Set<Car> cars = new LinkedHashSet<>();

	public void generateCar(String name) {
		Car newCar = new Car(name);
		validateDuplicatedCarName(newCar);
		cars.add(newCar);
	}

	public Set<Car> getCars() {
		return Collections.unmodifiableSet(cars);
	}

	private void validateDuplicatedCarName(Car newCar) {
		if (cars.contains(newCar)) {
			throw new IllegalArgumentException();
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
}
