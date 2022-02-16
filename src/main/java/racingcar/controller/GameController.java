package racingcar.controller;

import java.util.ArrayList;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private static final int ZERO = 0;
	Cars cars;
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
			generateCars(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(ZERO);
		}
	}

	private void playTotalTurn(int numberOfTurn) {
		for (int eachTurn = ZERO; eachTurn < numberOfTurn; eachTurn++) {
			cars.moveCars();
			OutputView.printCarPosition(cars.getCarsInfo());
		}
	}

	private void generateCars(String[] names) {
		ArrayList<Car> cars = new ArrayList<>();

		for (String name : names) {
			cars.add(new Car(name));
		}

		this.cars = new Cars(cars);
	}

	private ArrayList<String> getWinner() {
		ArrayList<String> winner = new ArrayList<>();

		isMaxPosition(winner);

		return winner;
	}

	private void isMaxPosition(ArrayList<String> winner) {
		int maxPosition = cars.getMaxPosition();

		for (Car car : cars.getCars()) {
			isSamePosition(winner, maxPosition, car);
		}
	}

	private void isSamePosition(ArrayList<String> winner, int maxPosition, Car car) {
		if (car.getPosition() == maxPosition) {
			winner.add(car.getName());
		}
	}
}
