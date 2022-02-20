package racingcar.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

	private final List<Car> cars;

	public CarRepository(final List<String> names) {
		cars = new ArrayList<>();
		createCarList(names);
	}

	private void createCarList(List<String> names) {
		names.forEach((name) -> cars.add(new Car(name)));
	}

	public List<String> getWinnersName() {
		final int farthestPosition = findFarthestPosition();
		return cars.stream()
			.filter((car) -> farthestPosition == car.getPosition())
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int findFarthestPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.getAsInt();
	}

	public void startThisTurn(final List<Integer> goForwardConditions) {
		Iterator<Integer> goForwardCondition = goForwardConditions.iterator();
		Iterator<Car> car = cars.listIterator();
		while(goForwardCondition.hasNext() && car.hasNext()) {
			car.next().startThisTurn(goForwardCondition.next());
		}
	}

	public List<Car> getThisTurnResult() {
		return cars;
	}

	public int getTheNumberOfCars() {
		return cars.size();
	}
}
