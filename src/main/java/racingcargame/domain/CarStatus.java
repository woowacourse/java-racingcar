package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class CarStatus {

	private List<Car> cars;

	CarStatus(List<Car> cars) {
		this.cars = cloneCars(cars);
	}

	private List<Car> cloneCars(List<Car> cars) {
		List<Car> tempCars = new ArrayList<>();
		cars.forEach(car -> tempCars.add(new Car(car)));
		return tempCars;
	}

	public List<Car> getCars() {
		return cars;
	}
}
