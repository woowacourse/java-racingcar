package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameTurn;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
	private Cars cars;
	private GameTurn gameTurn;

	public void makeCars() {
		try {
			cars = new Cars(InputView.getCarNames());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			makeCars();
		}
	}

	public void getGameTurn() {
		try {
			gameTurn = new GameTurn(InputView.getGameTurn());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getGameTurn();
		}
	}

	public void moveCars() {
		OutputView.printResultSentence();

		while (gameTurn.checkRemain()) {
			gameTurn.play();
			cars.moveCars();
			OutputView.printResult(cars.getRecentPosition());
		}
	}

	public void printWinners() {
		OutputView.printWinners(cars.findWinnerCars());
	}
}
