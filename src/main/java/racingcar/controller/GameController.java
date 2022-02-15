package racingcar.controller;

import java.util.ArrayList;

import racingcar.model.Car;
import racingcar.util.ErrorMessage;
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
		this.carList = generateCarList(carName);
		OutputView.askTurn();
		int totalTurn = InputView.getTurnInput();
		OutputView.displayResult();
		playTotalTurn(totalTurn);
		OutputView.displayWinner(outputViewController.mapWinner(carList));
	}

	private void playTotalTurn(int totalTurn) {
		for (int eachTurn = IntegerConst.ZERO.getValue(); eachTurn < totalTurn; eachTurn++) {
			carListController.moveCarList(carList);
			OutputView.displayCarPosition(outputViewController.getCarListInfo(carList, StringConst.POSITION_DELEIMIER.getValue()));
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
