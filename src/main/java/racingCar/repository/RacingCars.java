package racingCar.repository;

import java.util.ArrayList;
import java.util.List;

import racingCar.model.Car;

public class RacingCars {

	public List<Car> cars = new ArrayList<>();

	public void save(List<String> carNameList) throws Exception {
		for (String name : carNameList) {
			cars.add(new Car(name));
		}
	}
}
