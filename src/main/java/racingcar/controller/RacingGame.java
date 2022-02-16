package racingcar.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.models.Car;
import racingcar.utils.RandomNumber;
import racingcar.views.Input;
import racingcar.views.Output;

public class RacingGame {

	private List<Car> cars;
	private int repeats;

	public RacingGame() {
		cars = new ArrayList<>();
		repeats = 0;
	}

	public void startGame() {
		inputValidData();
		startRacing();
	}

	private void inputValidData() {
		createCar();
		repeats = Input.inputValidRepeats();
	}

	private void createCar() {
		final List<String> carNameList = Input.inputValidNames();
		carNameList.forEach((carName) -> cars.add(new Car(new RandomNumber(), carName)));
	}

	private void startRacing() {
		Output.printResultMessage();
		while(repeats-- > 0) {
			cars.forEach(Car::goForward);
			Output.printTurnResult(cars);
		}
		Output.printWinner(findWinner());
	}

	private List<Car> findWinner() {
		final int farthestPosition = findFarthestPosition();
		return getWinners(farthestPosition);
	}

	private int findFarthestPosition() {
		return cars.stream()
			.sorted(Comparator.comparing(Car::getPosition))
			.collect(Collectors.toList())
			.get(cars.size() - 1)
			.getPosition();
	}

	private List<Car> getWinners(final int farthestPosition) {
		return cars.stream()
			.filter((car) -> farthestPosition == car.getPosition())
			.collect(Collectors.toList());
	}
}
