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

	final Input input;
	final Output output;
	ArrayList<Car> cars;
	int repeats;

	public RacingGame(final Input input, final Output output) {
		this.input = input;
		this.output = output;
		cars = new ArrayList<>();
		repeats = 0;
	}

	public void startGame() {
		inputValidData();
		startRacing();
	}

	private void inputValidData() {
		createCar();
		repeats = input.inputValidRepeats();
	}

	private void createCar() {
		final List<String> carNameList = input.inputValidNames();
		carNameList.forEach((carName) -> cars.add(new Car(new RandomNumber(), carName)));
	}

	private void startRacing() {
		output.printResultMessage();
		while(repeats-- > 0) {
			cars.forEach(Car::goForward);
			output.printTurnResult(cars);
		}
		output.printWinner(findWinner());
	}

	private String findWinner() {
		final int farthestPosition = findFarthestPosition();
		final List<Car> winners = getWinners(farthestPosition);
		return joinWinnerNames(winners);
	}

	private int findFarthestPosition() {
		return cars.stream()
			.sorted(Comparator.comparing(Car::getPosition))
			.collect(Collectors.toList())
			.get(cars.size() - 1).getPosition();
	}

	private List<Car> getWinners(final int farthestPosition) {
		return cars.stream()
			.filter((car) -> farthestPosition == car.getPosition())
			.collect(Collectors.toList());
	}

	private String joinWinnerNames(final List<Car> winners) {
		final String[] winnerNames = winners.stream()
			.map(Car::getName)
			.toArray(String[]::new);
		return String.join(", ", winnerNames);
	}
}
