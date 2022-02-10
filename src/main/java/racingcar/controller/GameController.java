package racingcar.controller;

import racingcar.model.CarList;
import racingcar.util.IntegerConst;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	OutputViewController outputViewController = new OutputViewController();
	CarListController carListController = new CarListController();
	public void runRace() {
		OutputView.askCarName();
		String[] carName = InputView.getCarNameInput();
		if (carName[0].equals("[ERROR]")) {
			return;
		}
		CarList carList = new CarList(carName);
		OutputView.askTurn();
		int totalTurn = Integer.parseInt(InputView.getTurnInput());
		if (totalTurn < IntegerConst.ZERO.getValue()) {
			return;
		}
		OutputView.displayResult();
		for (int eachTurn = 0; eachTurn < totalTurn; eachTurn++) {
			carListController.moveCarList(carList);
			OutputView.displayCarPosition(outputViewController.mapCarList(carList));
		}
		OutputView.displayWinner(outputViewController.mapWinner(carList));
	}
}
