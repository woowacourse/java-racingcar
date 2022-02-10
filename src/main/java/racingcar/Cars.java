package racingcar;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	Set<Car> cars = new LinkedHashSet<>();

	public void generateCars(List<String> carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName, new RandomNumberGenerator(9, 0)));
		}
	}

	public int size() {
		return cars.size();
	}
}
