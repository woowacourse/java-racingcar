package racingcargame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarRepository {
	private List<Car> cars;

	public CarRepository(List<String> carNames) {
		cars = carNames.stream().
			map(carName -> new Car(carName, 0)).
			collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return cars;
	}

	void moveCars() {
		cars.forEach(Car::moveCar);
	}

	HashMap<String, Integer> bringCarsNameAndPosition() {
		HashMap<String, Integer> carsInformation = new HashMap<>();
		cars.forEach(car -> carsInformation.put(car.getName(), car.getPosition()));
		return carsInformation;
	}

	public List<String> findWinner() {
		List<String> winnerNames = new ArrayList<>();
		Collections.sort(cars, Collections.reverseOrder());
		int winnerPosition = cars.get(0).getPosition();
		cars.stream().
			filter(car -> car.getPosition() == winnerPosition).
			forEach(car -> winnerNames.add(car.getName()));
		return winnerNames;
	}
}
