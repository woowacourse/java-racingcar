package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameTurn;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
	private static final String COMMA_DELIMITER = ",";

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private Cars cars;
	private GameTurn gameTurn;

	public void makeCars() {
		cars = new Cars(toCar(getCarNames()));
	}

	private List<Car> toCar(List<String> carNames) {
		try {
			return carNames.stream()
				.map(Car::new)
				.collect(Collectors.toList());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return toCar(getCarNames());
		}
	}

	private List<String> getCarNames() {
		String inputCarNames = inputView.getCarNames();
		return splitCarNames(inputCarNames);
	}

	private List<String> splitCarNames(String carNames) {
		return Arrays.asList(carNames.split(COMMA_DELIMITER));
	}

	public void saveGameTurn() {
		try {
			String gameTurn = inputView.getGameTurn();
			this.gameTurn = new GameTurn(gameTurn);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			saveGameTurn();
		}
	}

	public void moveCars() {
		outputView.printResultSentence();
		while (gameTurn.isPositive()) {
			gameTurn.removeTurn();
			cars.moveCars();
			outputView.printResult(cars.getPosition());
		}
	}

	public void printWinners() {
		outputView.printWinners(cars.findWinnerCars());
	}
}
