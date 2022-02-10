package racingcar.model;

import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void moveCars() {
		cars.stream().forEach(Car::move);
	}

}
