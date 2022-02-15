package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameTurn;
import racingcar.service.CheckingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
	public static final String COMMA_DELIMITER = ",";

	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Cars cars;
	private GameTurn gameTurn;

	public void makeCars() {
		cars = new Cars(toCar(getCarNames()));
	}

	public List<Car> toCar(List<String> carNames) {
		return carNames.stream()
			.map(carName -> new Car(carName))
			.collect(Collectors.toList());
	}

	public List<String> getCarNames() {
		String inputCarNames = inputView.getCarNames();
		List<String> carNames = splitCarNames(inputCarNames);
		try {
			CheckingService.checkCarNamesBlank(inputCarNames);
			CheckingService.checkCarNamesLength(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCarNames();
		}

		return carNames;
	}

	public List<String> splitCarNames(String carNames) {
		return Arrays.asList(carNames.split(COMMA_DELIMITER));
	}

	public void saveGameTurn() {
		gameTurn = new GameTurn(getGameTurn());
	}

	public int getGameTurn() {
		String gameTurn = inputView.getGameTurn();
		try {
			CheckingService.checkGameTurnNumber(gameTurn);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getGameTurn();
		}
		return Integer.parseInt(gameTurn);
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
