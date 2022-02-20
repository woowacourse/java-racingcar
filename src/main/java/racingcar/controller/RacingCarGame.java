package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameTurn;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Cars cars;
	private GameTurn gameTurn;

	public void makeCars() {
		try {
			cars = new Cars(inputView.getCarNames());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			makeCars();
		}
	}

	public void getGameTurn() {
		try {
			gameTurn = new GameTurn(inputView.getGameTurn());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getGameTurn();
		}
	}

	public void moveCars() {
		outputView.printResultSentence();

		while (gameTurn.isPositive()) {
			gameTurn.removeTurn();
			cars.moveCars();
			outputView.printResult(cars.getPosition());
		}
	}

	public void printWinners() {
		outputView.printWinners(cars.findWinnerCars());
	}
}
