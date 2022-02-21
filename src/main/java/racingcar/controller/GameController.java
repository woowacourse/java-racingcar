package racingcar.controller;

import java.util.ArrayList;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public void runRace() {
		Game game = new Game(getCarNames(), getNumberOfTurn());
		printProcess(game);
		printResult(game);
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

	private Cars generateCars(String[] names) {
		ArrayList<Car> cars = new ArrayList<>();

		for (String name : names) {
			cars.add(new Car(name));
		}

		return new Cars(cars);
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

	private void printResult(Game game) {
		OutputView.printWinner(game.getWinner(game.getCars()));
	}

	private void printProcess(Game game) {
		OutputView.printResultMessage();
		game.playTotalTurn(game.getNumberOfTurn(), game.getCars());
	}

}
