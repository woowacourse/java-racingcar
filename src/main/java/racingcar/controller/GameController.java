package racingcar.controller;

import racingcar.model.CarList;
import racingcar.model.RandomNumberList;
import racingcar.view.InputViewChecker;
import racingcar.view.OutputView;
import racingcar.view.UserInputView;

public class GameController {

	public void runRace() {
		try {
			OutputView.askCarName();
			UserInputView userInputView = new UserInputView();
			CarList carList = new CarList(userInputView.getNameInput());
			OutputView.askTurn();
			playGame(userInputView.getTurnInput(), carList);
		} catch (IllegalArgumentException error) {
			OutputView.displayError(error.getMessage());
		}
	}

	private void playGame(int totalTurn, CarList carList) {
		OutputView.displayResult();
		for (int nowTurn = 0; nowTurn < totalTurn; nowTurn++) {
			moveCarList(carList);
			OutputView.displayCarPosition(carList.getNameList(), carList.getEachCarPosition());
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
