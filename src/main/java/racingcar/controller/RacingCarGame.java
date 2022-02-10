package racingcar.controller;

public class RacingCarGame {
	public void checkCarNames(String input) {
		if (input == null || input.equals("")) {
			throw new IllegalArgumentException();
		}
	}
}
