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
		Cars cars = new Cars(CarFactory.of(InputView.inputCarNames()));
		Set<Car> carSet = cars.getCars();
		int count = validateGameCount(InputView.inputGameCount());
		OutputView.printGameResultTitle();
		for (int i = 0; i < count ; i++) {
			play(carSet);
			showResult(carSet);
		}
		showWinner(Referee.judgeWinner(carSet, cars.getMaxPosition()));
	}

	public void play(Set<Car> cars) {
		for (Car car : cars) {
			boolean canCarMove = Referee.canCarMove(makeRandomValue());
			car.move(canCarMove);
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

	private int validateGameCount(int gameCount) {
		if(gameCount < ERROR_CRITERIA_VALUE_ZERO) {
			throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
		}
		return gameCount;
	}
}
