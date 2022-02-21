package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Game;
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
		Game game = new Game(cars, roundCount);
		printResult(game);
	}

	private void printResult(Game game) {
		outputView.printRoundResult(game.run());
		outputView.printWinners(game.getWinners());
	}
}
