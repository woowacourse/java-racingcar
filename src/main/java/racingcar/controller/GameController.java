package racingcar.controller;

import racingcar.model.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	OutputViewController outputViewController = new OutputViewController();
	CarListController carListController = new CarListController();
	public void runRace() {
		OutputView.askCarName();
		String[] carName = InputView.getCarNameInput();
		CarList carList = new CarList(carName);
		OutputView.askTurn();
		int totalTurn = InputView.getTurnInput();
		OutputView.displayResult();
		for (int eachTurn = 0; eachTurn < totalTurn; eachTurn++) {
			carListController.moveCarList(carList);
			OutputView.displayCarPosition(outputViewController.mapCarList(carList));
		}
		OutputView.displayWinner(outputViewController.mapWinner(carList));
	}
}
