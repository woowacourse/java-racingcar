package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RoundCount;
import racingcar.model.Winners;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarsController {

	private RoundCount roundCount;
	private Cars cars;
	private final Winners winners;

	public RacingCarsController(Winners winners) {
		this.winners = winners;
	}

	public void run() {
		requestCarNames();
		requestCount();
		startGame();
	}

	private void requestCarNames() {
		String carNames;
		do {
			carNames = Input.inputCarNames();
		} while (!isSaveCars(carNames));
	}

	private boolean isSaveCars(String carNames) {
		boolean safeSaveChecker = false;
		try {
			cars = new Cars(carNames);
			safeSaveChecker = true;
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
		}
		return safeSaveChecker;
	}

	private void requestCount() {
		try {
			roundCount = new RoundCount(Input.inputCount());
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCount();
		}
	}

	private void startGame() {
		Output.printResultMessage();
		runGame();
	}

	private void runGame() {
		while (roundCount.isOverZero()) {
			cars.startRound();
			Output.printRoundResult(cars.getCars());
		}
		endGame();
	}

	private void endGame() {
		Output.printWinners(winners.findWinner(cars.getCars()));
	}

}
