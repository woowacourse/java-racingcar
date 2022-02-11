package racingcar.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.util.IntegerConst;
import racingcar.util.StringConst;
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

	public LinkedHashMap<String, String> getCarListInfo(ArrayList<Car> carList) {
		LinkedHashMap<String, String> carListInfo = new LinkedHashMap<>();
		for (Car car : carList) {
			carListInfo.put(car.getName(), StringConst.POSITION_DELEIMIER.getValue().repeat(car.getPosition()));
		}
		return carListInfo;
	}
}
