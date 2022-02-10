package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.view.InputView;

public class RacingCarGame {
	private InputView inputView = new InputView();

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
}
