package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RoundCount;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarsController {

	private final Input inputView;
	private final Output outputView;
	private RoundCount roundCount;
	private Cars cars;

	public RacingCarsController(Input inputView, Output outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		requestCarNames();
		requestCount();
		startGame();
	}

	private void requestCarNames() {
		String carNames;
		do {
			carNames = inputView.inputCarNames();
		} while (!isSaveCars(carNames));
	}

	private boolean isSaveCars(String carNames) {
		boolean safeSaveChecker = false;
		try {
			cars = new Cars(carNames);
			safeSaveChecker = true;
		} catch (Exception exception) {
			outputView.printError(exception.getMessage());
		}
		return safeSaveChecker;
	}

	private void requestCount() {
		try {
			roundCount = new RoundCount(inputView.inputCount());
		} catch (Exception exception) {
			outputView.printError(exception.getMessage());
			requestCount();
		}
	}

	private void startGame() {
		outputView.printResultMessage();
		runGame();
	}

	private void runGame() {
		while (roundCount.isOverZero()) {
			cars.startRound();
			outputView.printRoundResult(cars.getCars());
		}
		endGame();
	}

	private void endGame() {
		outputView.printWinners(cars.findWinner(cars.getCars()));
	}

}
