package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceCount;
import racingcar.utils.carsNameSpliter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;

public class RaceController {
	public static void run() {
		Race race = new Race(createCars(), createRaceCount());
		showRaceStart();

		while (race.isProgress()) {
			race.run();
			showCurrentPosition(race.getCarsCurrentPosition());
		}

		showWinnersName(race.getWinnersName());
	}

	private static Cars createCars() {
		try {
			String carsName = InputView.getCarsNameInput();
			return new Cars(carsNameSpliter.split(carsName));
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return createCars();
		}
	}

	private static RaceCount createRaceCount() {
		try {
			String raceCount = InputView.getRaceCountInput();
			return new RaceCount(raceCount);
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
