package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceCount;
import racingcar.utils.InputUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;
import java.util.List;

public class RaceController {
	public static void run() {
		Race race = new Race(new Cars(readCars()), new RaceCount(readRaceCount()));

		OutputView.printRaceStart();
		while (!race.isEnd()) {
			race.run();
			OutputView.printCurrentPosition(race.getCars());
		}
		OutputView.printWinnersName(race.getWinnersName());
	}

	private static List<String> readCars() {
		try {
			InputView.printCarsNameInput();
			return InputUtil.inputCars();
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printExceptionMessage(e);
			return readCars();
		}
	}

	private static String readRaceCount() {
		try {
			InputView.printRaceCountInput();
			return InputUtil.inputRaceCount();
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printExceptionMessage(e);
			return readRaceCount();
		}
	}
}
