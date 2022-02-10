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
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Cars cars;
	private GameTurn gameTurn;

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

	public void checkCarNamesBlank(String input) {
		if (input == null || input.equals("")) {
			throw new IllegalArgumentException("[Error] 다시 이름을 입력하세요");
		}
	}

	public List<String> splitCarNames(String carNames) {
		return Arrays.asList(carNames.split(","));
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

	public void checkCarNamesLength(List<String> carNames) {
		if (carNames.stream()
			.anyMatch(carName -> carName.length() > 5)) {
			throw new IllegalArgumentException("[Error] 5자 이하의 이름을 입력하세요.");
		}
	}

	public void checkGameTurnNumber(String gameTurn) {
		if (!gameTurn.matches("[1-9]\\d*")) {
			throw new IllegalArgumentException("[Error] 숫자를 입력하세요.");
		}
	}

	public List<Car> toCar(List<String> carNames) {
		return carNames.stream()
			.map(carName -> new Car(carName))
			.collect(Collectors.toList());
	}

	public void makeCars() {
		cars = new Cars(toCar(getCarNames()));
	}

	public void saveGameTurn() {
		gameTurn = new GameTurn(getGameTurn());
	}

	public void moveCars() {
		while (gameTurn.isPositive()) {
			gameTurn.removeTurn();
			cars.moveCars();
			outputView.printResult(cars.getPosition());
		}
	}
}
