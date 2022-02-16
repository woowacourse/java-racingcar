package racingcar;

import java.util.Set;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.CarFactory;
import racingcar.domain.Game;
import racingcar.domain.UniqueCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";

	public static void run() {
		final int count = InputView.inputGameCount();
		validateCount(count);
		Game game = new Game(new UniqueCars(CarFactory.of(InputView.inputCarNames())));
		play(game, count);
		showWinner(game.getWinners());
	}

	private static void play(Game game, int count) {
		OutputView.printGameResultTitle();
		for (int i = 0; i < count; i++) {
			showResult(game.play());
		}
	}

	private static void showResult(UniqueCars uniqueCars) {
		for (Car car : uniqueCars.getCars()) {
			OutputView.printCarPosition(new CarDto(car.getName(), car.getPosition()));
		}
		OutputView.printBlankLine();
	}

	private static void showWinner(Set<Car> winners) {
		final Set<CarDto> winnerDtos = winners.stream()
			.map(car -> new CarDto(car.getName()))
			.collect(Collectors.toSet());
		OutputView.printWinner(winnerDtos);
	}

	private static void validateCount(int count) {
		if(count < 0) {
			throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
		}
	}
}
