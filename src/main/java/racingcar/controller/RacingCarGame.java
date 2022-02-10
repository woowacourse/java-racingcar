package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarGame {
	private InputView inputView = new InputView();

	public void getCarNames() {
		String carNames = inputView.getCarNames();
		try {
			checkCarNames(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getCarNames();
		}
	}

	public void checkCarNames(String input) {
		if (input == null || input.equals("")) {
			throw new IllegalArgumentException("[Error] 다시 이름을 입력하세요");
		}
	}
}
