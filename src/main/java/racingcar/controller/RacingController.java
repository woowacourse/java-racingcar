package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {
	CarController carController = new CarController();

	public RacingController() {
		carController.createCars(InputView.getCarNames());
	}

	public void run(int iteration) {
		for (int i = 0; i < iteration; i++) {
			carController.run();
		}
	}
}
