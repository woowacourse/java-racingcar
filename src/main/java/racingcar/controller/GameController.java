package racingcar.controller;

import java.util.ArrayList;

import racingcar.model.Car;
import racingcar.util.IntegerConst;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	OutputViewController outputViewController = new OutputViewController();
	CarListController carListController = new CarListController();
	ArrayList<Car> carList;

	public void runRace() {
		OutputView.askCarName();
		String[] carName = InputView.getCarNameInput();
		if (carName[0].equals("[ERROR]")) {
			return;
		}
		ArrayList<Car> carList = generateCarList(carName);
		OutputView.askTurn();
		int totalTurn = Integer.parseInt(InputView.getTurnInput());
		if (totalTurn < IntegerConst.ZERO.getValue()) {
			return;
		}
		OutputView.displayResult();
		for (int eachTurn = 0; eachTurn < totalTurn; eachTurn++) {
			carListController.moveCarList(carList);
			OutputView.displayCarPosition(outputViewController.getCarListInfo(carList));
		}
		OutputView.displayWinner(outputViewController.mapWinner(carList));
	}

	public ArrayList<Car> generateCarList(String[] names) {
		this.carList = new ArrayList<>();
		for (String name : names) {
			carList.add(new Car(name));
		}

		return this.carList;
	}

	public int getMaxPosition(ArrayList<Car> carList) {
		int max = 0;
		for (Car car : carList) {
			max = Math.max(max, car.getPosition());
		}
		return max;
	}
}
