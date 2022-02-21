package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.model.RoundCount;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarsController {

	private final Input inputView;
	private final Output outputView;

	public RacingCarsController(Input inputView, Output outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		Cars cars = Cars.from(inputView.inputCarNames());
		RoundCount roundCount = new RoundCount(inputView.inputCount());
		RacingGame racingGame = new RacingGame(cars, roundCount);
		printResult(racingGame);
	}

	private void printResult(RacingGame racingGame) {
		outputView.printRoundResult(racingGame.run());
		outputView.printWinners(racingGame.getWinners());
	}
}
