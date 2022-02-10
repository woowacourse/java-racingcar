package racingcar;

import java.util.Scanner;

public class RacingCarController {
	public final Cars cars = new Cars();

	public void playGame() {
		cars.generateCars(InputManager.splitAndSaveCarNames(InputView.inputCarNames()));
		int trialCount = InputManager.getTrial(InputView.inputTrials());

	}
}
