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
	private static final String NULL_EMPTY_CAR_NAME_ERROR_MESSAGE = "[Error] 다시 이름을 입력하세요";
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = String.format("[Error] %d자 이하의 이름을 입력하세요.",
		MAX_CAR_NAME_LENGTH);
	private static final String GAME_TURN_NUMBER_ERROR_MESSAGE = "[Error] 숫자를 입력하세요.";
	private static final String RANDOM_NUMBER_REGEX = "[1-9]\\d*";
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private Cars cars;
	private GameTurn gameTurn;

	public void makeCars() {
		cars = new Cars(toCar(getCarNames()));
	}

	public List<Car> toCar(List<String> carNames) {
		return carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public List<String> getCarNames() {
		String inputCarNames = inputView.getCarNames();
		List<String> carNames = splitCarNames(inputCarNames);
		try {
			checkCarNamesBlank(inputCarNames);
			checkCarNamesLength(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCarNames();
		}

		return carNames;
	}

	public List<String> splitCarNames(String carNames) {
		return Arrays.asList(carNames.split(COMMA_DELIMITER));
	}

	public void checkCarNamesBlank(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException(NULL_EMPTY_CAR_NAME_ERROR_MESSAGE);
		}
	}

	public void checkCarNamesLength(List<String> carNames) {
		if (carNames.stream()
			.anyMatch(carName -> carName.length() > MAX_CAR_NAME_LENGTH)) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	public void saveGameTurn() {
		gameTurn = new GameTurn(getGameTurn());
	}

	public int getGameTurn() {
		String gameTurn = inputView.getGameTurn();
		try {
			checkGameTurnNumber(gameTurn);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getGameTurn();
		}
		return Integer.parseInt(gameTurn);
	}

	public void checkGameTurnNumber(String gameTurn) {
		if (!gameTurn.matches(RANDOM_NUMBER_REGEX)) {
			throw new IllegalArgumentException(GAME_TURN_NUMBER_ERROR_MESSAGE);
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
