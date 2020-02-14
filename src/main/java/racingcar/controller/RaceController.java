package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceCount;
import racingcar.utils.InputUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;

public class RaceController {
	public static void run() {
		Race race = new Race(createCars(), createRaceCount());
		race.run();
	}

	private static Cars createCars() {
		try {
			InputView.printCarsNameInput();
			return InputUtil.createCarsByInput();
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return createCars();
		}
	}

	private static RaceCount createRaceCount() {
		try {
			InputView.printRaceCountInput();
			return InputUtil.createRaceCountByInput();
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return createRaceCount();
		}
	}

	public static void showCurrentPosition(String currentPosition) {
		OutputView.printCurrentPosition(currentPosition);
	}

	public static void showRaceStart() {
		OutputView.printRaceStart();
	}

	public static void showWinnersName(String winnersName) {
		OutputView.printWinnersName(winnersName);
	}
}
