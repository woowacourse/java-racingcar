package racingcar.controller;

import racingcar.model.CarList;
import racingcar.model.RandomNumberList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private static final String POSITION_DELIMITER = "-";

	public void runRace() {
		try {
			OutputView.askCarName();
			CarList carList = new CarList(InputView.getCarNameInput());
			OutputView.askTurn();
			int totalTurn = InputView.getTurnInput();
			playGame(totalTurn, carList);
		} catch (IllegalArgumentException error) {
			OutputView.displayError(error.getMessage());
		}
	}

	private void playGame(int totalTurn, CarList carList) {
		OutputView.displayResult();
		for (int nowTurn = 0; nowTurn < totalTurn; nowTurn++) {
			moveCarList(carList);
			OutputView.displayCarPosition(carList.getNameList(), carList.getEachCarPosition(), POSITION_DELIMITER);
		}
		OutputView.displayWinner(carList.getWinnerNames());
	}

	private void moveCarList(CarList carList) {
		int size = carList.getTotalCount();
		RandomNumberList randomNumberList = new RandomNumberList(size);
		for (int index = 0; index < size; index++) {
			carList.moveCarAt(index, randomNumberList.getNumberAt(index));
		}
	}
}
