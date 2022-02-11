package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
	private final CarController carController;

	public RacingController() {
		this.carController = new CarController();
		createCars();
	}

	public void run() {
		int iteration = InputView.getIterationNo();
		ResultView.printBeforeGameResult();
		runInIteration(iteration);
		ResultView.printWinners(carController.getWinners());
	}

	private void runInIteration(int iteration) {
		for (int i = 0; i < iteration; i++) {
			carController.run();
			ResultView.printGameResult(carController.getCars());
		}
	}

	private void createCars() {
		try {
			carController.createCars(InputView.getCarNames());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			createCars();
		}
	}
}
