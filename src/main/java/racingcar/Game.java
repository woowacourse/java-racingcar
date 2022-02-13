package racingcar;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
	private static final String WINNER_NAME_DELIMITER = ", ";
	private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";
	private static final int ERROR_CRITERIA_VALUE_ZERO = 0;

	private final Random random = new Random();

	public void start() {
		Set<Car> cars = CarFactory.of(InputView.inputCarNames());
		int count = InputView.inputGameCount();
		validateGameCount(count);
		OutputView.printGameResultTitle();
		for (int i = 0; i < count ; i++) {
			play(cars);
			showResult(cars);
		}
		showWinner(Referee.judgeWinner(cars));
	}

	public void play(Set<Car> cars) {
		for (Car car : cars) {
			Referee.judgeCarMove(car, makeRandomValue());
		}
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
		return random.nextInt(10);
	}

	private void validateGameCount(int gameCount) {
		if(gameCount < ERROR_CRITERIA_VALUE_ZERO) {
			throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
		}
	}
}
