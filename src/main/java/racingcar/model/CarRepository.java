package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
	private static CarRepository instance;
	private List<Car> cars = new ArrayList<>();
	private RandomNo randomNo = new RandomNo();

	public static CarRepository getInstance() {
		if (instance == null) {
			instance = new CarRepository();
		}
		return instance;
	}

	public void save(Car car) {
		cars.add(car);
	}

	public int size() {
		return cars.size();
	}

	public void clear() {
		cars.clear();
	}

	public void move() {
		for (Car car : cars) {
			car.move(randomNo.getNumber());
		}
	}
}
