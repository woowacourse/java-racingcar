package racingcar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {
	private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";
	private static final int RANDOM_VALUE_BOUND = 9;

	public void start() {
		Cars cars = new Cars(CarFactory.of(InputView.inputCarNames()));
		int count = InputView.inputGameCount();
		validateGameCount(count);
		OutputView.printGameResultTitle();
		for (int i = 0; i < count ; i++) {
			play(cars);
			showResult(cars);
		}
		showWinner(cars);
	}

	private void play(Cars cars) {
		for (Car car : cars.getCars()) {
			Referee.moveCar(car, makeRandomValue(RANDOM_VALUE_BOUND + 1));
		}
	}

	private void showResult(Cars cars) {
		for (Car car : cars.getCars()) {
			OutputView.printCarPosition(new CarDto(car.getName(), car.getPosition()));
		}
		OutputView.printBlankLine();
	}

	private void showWinner(Cars cars) {
		List<CarDto> winnerDtos = Referee.judgeWinner(cars).stream()
			.map(car -> new CarDto(car.getName()))
			.collect(Collectors.toList());
		OutputView.printWinner(winnerDtos);
	}

	public int makeRandomValue(int bound) {
		Random random = new Random();
		return random.nextInt(bound);
	}

	private void validateGameCount(int gameCount) {
		if(gameCount < 0) {
			throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
		}
	}
}
