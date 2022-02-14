package racingcargame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<String> carNames) {
		cars = carNames.stream().
			map(carName -> new Car(carName, 0)).
			collect(Collectors.toList());
	}

	void moveCars() {
		cars.forEach(Car::moveCar);
	}

	HashMap<String, Integer> bringCarsPositionSeparatedByName() {
		HashMap<String, Integer> carsPosition = new HashMap<>();
		cars.forEach(car -> carsPosition.put(car.getName(), car.getPosition()));
		return carsPosition;
	}

	List<String> findWinner() {
		int winnerPosition = findWinnerPosition();
		return cars.stream()
			.filter(car -> car.getPosition() == winnerPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int findWinnerPosition() {
		return cars.stream()
			.max(Comparator.comparingInt(Car::getPosition)).
			get().
			getPosition();
	}

	public List<Car> getCars() {
		return cars;
	}
}
