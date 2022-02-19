package racingcar.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.RacingGameMessage;

public class CarRepository {

	private final List<Car> cars;

	public CarRepository(final String names) {
		cars = new ArrayList<>();
		createCarList(splitNames(names));
	}

	private void createCarList(List<String> names) {
		names.forEach((name) -> cars.add(new Car(name)));
	}

	private List<String> splitNames(final String names) {
		return Arrays.stream(names.split(RacingGameMessage.CAR_NAME_DISTRIBUTOR))
			.collect(Collectors.toList());
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

	public void startThisTurn() {
		cars.forEach(Car::goForward);
	}

	public List<Car> getThisTurnResult() {
		return cars;
	}
}
