package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
	CarController carController = new CarController();

	public RacingController() {
		carController.createCars(InputView.getCarNames());
	}

	public void run() {
		int iteration = InputView.getIterationNo();
		ResultView.printBeforeGameResult();
		for (int i = 0; i < iteration; i++) {
			carController.run();
			ResultView.printGameResult(carController.getCars());
		}
		ResultView.printWinners(carController.getWinners());
	}
}
