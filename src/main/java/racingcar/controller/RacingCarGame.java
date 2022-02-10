package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.view.InputView;

public class RacingCarGame {
	private InputView inputView = new InputView();

	public List<String> getCarNames() {
		String carNames = inputView.getCarNames();

		try {
			checkCarNames(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCarNames();
		}

		return splitCarNames(carNames);
	}

	public void checkCarNames(String input) {
		if (input == null || input.equals("")) {
			throw new IllegalArgumentException("[Error] 다시 이름을 입력하세요");
		}
	}

	public List<String> splitCarNames(String carNames) {
		return Arrays.asList(carNames.split(","));
	}

	public int getGameTurn() {
		String gameTurn = inputView.getGameTurn();
		return Integer.parseInt(gameTurn);
	}
}
