package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.util.BoundedRandomNumberGenerator;

public class ParticipateCars {
	private static final int MAX_BOUND = 9;
	private static final int MIN_BOUND = 0;
	private static final int FASTEST_CAR_INDEX = 0;
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

	public WinnerNames findWinners() {
		return getWinnerNamesWithFirstCar(findFastestCar());
	}

	private Car findFastestCar() {
		Collections.sort(cars);
		return cars.get(FASTEST_CAR_INDEX);
	}

	private WinnerNames getWinnerNamesWithFirstCar(Car firstCar) {
		WinnerNames winnerNames = new WinnerNames();
		for (Car car : cars) {
			winnerNames.addWinnerByFastestCar(car, firstCar);
		}
		return winnerNames;
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
