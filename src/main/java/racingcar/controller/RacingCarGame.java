package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameTurn;
import racingcar.service.CheckingService;
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

	public void saveGameTurn() {
		gameTurn = new GameTurn(getGameTurn());
	}

	public int getGameTurn() {
		String gameTurn = inputView.getGameTurn();
		try {
			CheckingService.checkGameTurnNumber(gameTurn);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getGameTurn();
		}
		return Integer.parseInt(gameTurn);
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
