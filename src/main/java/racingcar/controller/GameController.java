package racingcar.controller;

import java.util.ArrayList;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private static final int ZERO = 0;
	CarList carList;
	int numberOfTurn = ZERO;

	public void runRace() {
		getCarNames();
		getNumberOfTurn();
		printProcess();
		printResult();
	}

	private void printResult() {
		OutputView.printWinner(getWinner());
	}

	private void printProcess() {
		OutputView.printResultMessage();
		playTotalTurn(numberOfTurn);
	}

	private void getNumberOfTurn() {
		OutputView.askTurn();
		try {
			numberOfTurn = InputView.getNumberOfTurn();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(ZERO);
		}
	}

	private void getCarNames() {
		OutputView.askCarName();
		String[] carNames = InputView.getCarNames();
		try {
			generateCarList(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(ZERO);
		}
	}

	private void playTotalTurn(int numberOfTurn) {
		for (int eachTurn = ZERO; eachTurn < numberOfTurn; eachTurn++) {
			carList.moveCarList();
			OutputView.printCarPosition(carList.getCarListInfo());
		}
	}

	private void generateCarList(String[] names) {
		ArrayList<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		this.carList = new CarList(cars);
	}

	private ArrayList<String> getWinner() {
		ArrayList<String> winner = new ArrayList<>();
		isMaxPosition(winner);
		return winner;
	}

	private void isMaxPosition(ArrayList<String> winner) {
		int maxPosition = carList.getMaxPosition();
		for (Car car : carList.getCarList()) {
			if (car.getPosition() == maxPosition) {
				winner.add(car.getName());
			}
		}
	}
}
