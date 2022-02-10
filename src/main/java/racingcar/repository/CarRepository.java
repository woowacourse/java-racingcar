package racingcar.repository;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;

public class CarRepository {
	private static final ArrayList<Car> cars = new ArrayList<>();

	public void addCar(Car car) {
		cars.add(car);
	}

	public int count() {
		return cars.size();
	}

	public List<Car> findCars() {
		return new ArrayList<>(cars);
	}
}
