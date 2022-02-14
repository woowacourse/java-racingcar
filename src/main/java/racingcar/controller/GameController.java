package racingcar.controller;

import java.util.ArrayList;

import racingcar.model.Car;
import racingcar.util.IntegerConst;
import racingcar.util.StringConst;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	OutputViewController outputViewController = new OutputViewController();
	CarListController carListController = new CarListController();
	private ArrayList<Car> carList;

	public void runRace() {
		OutputView.askCarName();
		String[] carName = InputView.getCarNameInput();
		checkNameError(carName);
		this.carList = generateCarList(carName);
		OutputView.askTurn();
		int totalTurn = Integer.parseInt(InputView.getTurnInput());
		checkTurnError(totalTurn);
		OutputView.displayResult();
		playTotalTurn(totalTurn);
		OutputView.displayWinner(outputViewController.mapWinner(carList));
	}

	private void checkNameError(String[] carName) {
		if (carName[IntegerConst.ZERO.getValue()].equals(StringConst.ERROR_PREFIX.getValue())) {
			System.exit(0);
		}
	}

	private void checkTurnError(int totalTurn) {
		if (totalTurn < IntegerConst.ZERO.getValue()) {
			System.exit(0);
		}
	}

	private void playTotalTurn(int totalTurn) {
		for (int eachTurn = IntegerConst.ZERO.getValue(); eachTurn < totalTurn; eachTurn++) {
			carListController.moveCarList(carList);
			OutputView.displayCarPosition(outputViewController.getCarListInfo(carList));
		}
	}

	public ArrayList<Car> generateCarList(String[] names) {
		ArrayList<Car> carList = new ArrayList<>();
		for (String name : names) {
			carList.add(new Car(name));
		}
		return carList;
	}

	public int getMaxPosition(ArrayList<Car> carList) {
		int max = IntegerConst.ZERO.getValue();
		for (Car car : carList) {
			max = Math.max(max, car.getPosition());
		}
		return max;
	}
}
