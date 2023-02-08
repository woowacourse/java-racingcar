package racingcar.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Cars {
	private final Set<Car> cars = new LinkedHashSet<>();

	public void generateCar(String name) {
		Car newCar = new Car(name);
		validateDuplicatedCarName(newCar);
		cars.add(newCar);
	}

	private void validateDuplicatedCarName(Car newCar) {
		if (cars.contains(newCar)) {
			throw new IllegalArgumentException();
		}
	}
}
