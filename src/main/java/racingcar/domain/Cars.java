package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.util.BoundedRandomNumberGenerator;

public class Cars {
	private static final int MAX_BOUND = 9;
	private static final int MIN_BOUND = 0;
	private final List<Car> cars = new ArrayList<>();

	public void generateCars(List<String> carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName, new BoundedRandomNumberGenerator(MAX_BOUND, MIN_BOUND)));
		}
	}

	public int getSize() {
		return cars.size();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public List<String> findWinners(WinnerNames winnerNames) {
		return getWinnerNamesWithFirstCar(findFastestCar(), winnerNames);
	}

	private Car findFastestCar() {
		Collections.sort(cars);
		return cars.get(0);
	}

	private List<String> getWinnerNamesWithFirstCar(Car firstCar, WinnerNames winnerNames) {
		for (Car car : cars) {
			winnerNames.addWinnerByFastestCar(car, firstCar);
		}
		return winnerNames.getWinnerNames();
	}

	public List<String> executeCarRacing() {
		List<String> racingRecord = new ArrayList<>();
		for (Car car : cars) {
			car.tryMoving();
			racingRecord.add(car.toString());
		}
		return racingRecord;
	}
}
