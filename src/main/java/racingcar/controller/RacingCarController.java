package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.InputManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	public final Cars cars = new Cars();

	public void playGame() {
		cars.generateCars(InputManager.splitAndSaveCarNames(InputView.inputCarNames()));
		int trialCount = InputManager.getTrial(InputView.inputTrials());

		OutputView.printResultMessage();
		for (int i = 0; i < trialCount; i++) {
			OutputView.printRacingRecords(cars.executeCarRacing());
		}

		OutputView.printWinnerNames(cars.findWinners());
	}
}
