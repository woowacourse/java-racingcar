package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import racingcar.util.RandomNumberGenerator;

public class Cars {
	private final List<Car> cars;

	public Cars(List<String> carNames) {
		cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public int getSize() {
		return cars.size();
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

	public void executeCarRacing(RandomNumberGenerator randomNumberGenerator) {
		for (Car car : cars) {
			car.tryMoving(randomNumberGenerator.generate());
		}
	}

	public Map<String, Integer> getRacingRecord() {
		Map<String, Integer> racingRecord = new LinkedHashMap<>();
		for (Car car : cars) {
			racingRecord.put(car.getCarName(), car.getCarPosition());
		}
		return racingRecord;
	}
}
