package racingcar.controller;

import java.util.ArrayList;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public void runRace() {
		Cars cars = getCarNames();
		printProcess(getNumberOfTurn(), cars);
		printResult(cars);
	}

	private void printResult(Cars cars) {
		OutputView.printWinner(getWinner(cars));
	}

	private void printProcess(int numberOfTurn, Cars cars) {
		OutputView.printResultMessage();
		playTotalTurn(numberOfTurn, cars);
	}

	private int getNumberOfTurn() {
		OutputView.askTurn();
		try {
			return InputView.getNumberOfTurn();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getNumberOfTurn();
		}
	}

	private Cars getCarNames() {
		OutputView.askCarName();

		String[] carNames = InputView.getCarNames();

		try {
			return generateCars(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCarNames();
		}
	}

	private void playTotalTurn(int number, Cars cars) {
		for (int index = 0; index < number; index++) {
			cars.moveCars();
			OutputView.printCarPosition(cars.getCarsInfo());
		}
	}

	private Cars generateCars(String[] names) {
		ArrayList<Car> cars = new ArrayList<>();

		for (String name : names) {
			cars.add(new Car(name));
		}

		return new Cars(cars);
	}

	private ArrayList<String> getWinner(Cars cars) {
		final ArrayList<String> winner = new ArrayList<>();

		isMaxPosition(winner, cars);

		return winner;
	}

	private void isMaxPosition(ArrayList<String> winner, Cars cars) {
		int maxPosition = cars.getMaxPosition();

		for (Car car : cars.getCars()) {
			isSamePosition(winner, maxPosition, car);
		}
	}

	private void isSamePosition(ArrayList<String> winner, int position, Car car) {
		if (car.getPosition() == position) {
			winner.add(car.getName());
		}
	}
}
