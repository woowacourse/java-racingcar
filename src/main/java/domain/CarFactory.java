package domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
	public static List<Car> arrangeCars(String carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames.split(",")) {
			cars.add(new Car(carName));
		}
		return cars;
	}
}
