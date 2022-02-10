package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
	private static CarRepository instance;
	private final List<Car> cars = new ArrayList<>();
	private final RandomNo randomNo = new RandomNo();

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

	public List<Car> getWinners() {
		int maxPosition = getMaxPosition();

		List<Car> winnerCars = new ArrayList<>();
		for (Car car : cars) {
			if (car.isSamePosition(maxPosition)) {
				winnerCars.add(car);
			}
		}
		return winnerCars;
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = car.getBiggerPosition(maxPosition);
		}
		return maxPosition;
	}

	public List<Car> getCars() {
		return cars;
	}
}
