package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceCount;
import racingcar.utils.carsNameSpliter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;
import java.util.List;

public class RaceController {
	public static void run() {
		Race race = new Race(createCars(), createRaceCount());
		showRaceStart();

		while (race.isProgress()) {
			race.run();
			showCurrentPosition(race.getCars());
		}

		showWinnersName(race.getWinners());
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

	public static void showCurrentPosition(List<Car> cars) {
		OutputView.printCurrentPosition(cars);
	}

	public static void showRaceStart() {
		OutputView.printRaceStart();
	}

	public static void showWinnersName(List<Car> cars) {
		OutputView.printWinnersName(cars);
	}
}
