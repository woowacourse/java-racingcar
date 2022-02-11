package racingcargame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
	private List<Car> cars;

	public CarRepository(final List<String> carNames) {
		cars = carNames.stream().
			map(carName -> new Car(carName, 0)).
			collect(Collectors.toList());
	}

	void moveCars() {
		cars.forEach(Car::moveCar);
	}

	HashMap<String, Integer> bringCarsNameAndPosition() {
		HashMap<String, Integer> carsInformation = new HashMap<>();
		cars.forEach(car -> carsInformation.put(car.getName(), car.getPosition()));
		return carsInformation;
	}

	List<String> findWinner() {
		List<String> winnerName = new ArrayList<>();
		cars.sort(Collections.reverseOrder());
		int winnerPosition = cars.get(0).getPosition();
		cars.stream().
			filter(car -> car.getPosition() == winnerPosition).
			forEach(car -> winnerName.add(car.getName()));
		return winnerName;
	}

	public List<Car> getCars() {
		return cars;
	}
}
