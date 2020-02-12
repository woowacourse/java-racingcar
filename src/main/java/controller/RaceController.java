package controller;

import domain.Cars;
import domain.Race;
import utils.InputUtil;
import view.InputView;
import view.OutputView;

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
