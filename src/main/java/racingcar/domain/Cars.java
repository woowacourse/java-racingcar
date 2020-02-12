package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public Car getCarOnMaxPosition() {
		Collections.sort(cars);
		return cars.get(0);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Car car : cars) {
			sb.append(car);
		}
		return sb.toString();
	}
}
