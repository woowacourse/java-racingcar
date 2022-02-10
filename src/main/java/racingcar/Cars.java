package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Cars {
	List<Car> cars = new ArrayList<>();

	public void generateCars(List<String> carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName, new RandomNumberGenerator(9, 0)));
		}
	}

	public int size() {
		return cars.size();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public List<String> findWinners() {
		Collections.sort(cars);
		List<String> winnerNames = new ArrayList<>();
		Car firstCar = cars.get(0);
		for (Car car : cars) {
			if (firstCar.compareTo(car) == 0) {
				winnerNames.add(car.getCarName());
				continue;
			}
			break;
		}
		return winnerNames;
	}

	public void executeCarRacing() {
		for (Car car : cars) {
			car.tryDrive();
		}
	}
}
