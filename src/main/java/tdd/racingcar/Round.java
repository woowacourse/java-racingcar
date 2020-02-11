package tdd.racingcar;

public class Round {
	private int round;

	public Round(String value) {
		checkValidationFor(value);
		round = Integer.parseInt(value);
	}

	private void checkValidationFor(String value) {
		if (isNotNumber(value)) {
			throw new IllegalArgumentException("횟수는 숫자이어야 합니다.");
		}
	}

	private boolean isNotNumber(String value) {
		return value.chars().anyMatch(ch -> !Character.isDigit(ch));
	}
}
