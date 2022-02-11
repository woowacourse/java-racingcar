package racingcar;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {

	public static final String WINNER_NAME_DELIMITER = ", ";

	public void start() {
		Set<Car> cars = CarFactory.of(InputView.inputCarNames());
		int count = InputView.inputGameCount();
		OutputView.printGameResultTitle();
		play(cars);
		showResult(cars);
		showWinner(Referee.judgeWinner(cars));
	}

	public Set<Car> play(Set<Car> cars) {
		for (Car car : cars) {
			Referee.judgeCarMove(car, makeRandomValue());
		}
		return cars;
	}

	public void showResult(Set<Car> cars) {
		for (Car car : cars) {
			OutputView.printLineString(car.toString());
		}
		OutputView.printBlankLine();
	}

	public void showWinner(List<Car> winnerCars) {
		String winnerNames = winnerCars.stream()
			.map(Car::getName).collect(Collectors.joining(WINNER_NAME_DELIMITER));
		OutputView.printWinner(winnerNames);
	}

	public int makeRandomValue() {
		Random random = new Random();
		return random.nextInt(10);
	}
}
