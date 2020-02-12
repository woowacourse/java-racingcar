package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.utils.InputUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;

public class RaceController {
	public static void run() {
		//Race race = new Race(readCars(), readRaceCount());
	}

	private static Cars readCars() {
		try {
			InputView.printCarsNameInput();
			return InputUtil.createCarsByInput();
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printExceptionMessage(e);
			return readCars();
		}
	}
}
