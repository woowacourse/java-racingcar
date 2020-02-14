package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.CarsFactory;
import racingcar.domain.Race;
import racingcar.domain.RaceCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;
import java.util.List;

public class RaceController {
	public static void run() {
		Race race = new Race(createCarsUntilValid(), createRaceCount());
		showRaceStart();

		while (race.isProgress()) {
			race.run();
			showCurrentPosition(race.getCars());
		}

		showWinnersName(race.getWinners());
	}

	private static Cars createCarsUntilValid() {
		try {
			String carsNameInput = InputView.getCarsNameInput();
			return CarsFactory.createCars(carsNameInput);
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return createCarsUntilValid();
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
