package racingcar.model;

import java.util.ArrayList;

import racingcar.view.OutputView;

public class Game {

	private final Cars cars;
	private final int NumberOfTurn;

	public Game(Cars cars, int numberOfTurn) {
		this.cars = cars;
		NumberOfTurn = numberOfTurn;
	}

	public Cars getCars() {
		return cars;
	}

	public int getNumberOfTurn() {
		return NumberOfTurn;
	}

	public void playTotalTurn(int number, Cars cars) {
		for (int index = 0; index < number; index++) {
			cars.moveCars();
			OutputView.printCarPosition(cars.getCarsInfo());
		}
	}

	public ArrayList<String> getWinner(Cars cars) {
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
