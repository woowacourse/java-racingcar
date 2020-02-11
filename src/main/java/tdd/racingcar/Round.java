package tdd.racingcar;

public class Round {
	private static final int ONE = 1;

	private int round;

	public Round(final String value) {
		checkValidationFor(value);
		round = Integer.parseInt(value);
	}

	private void checkValidationFor(final String value) {
		if (isNotNumber(value)) {
			throw new IllegalArgumentException("횟수는 숫자이어야 합니다.");
		}
		if (isUnderOne(value)) {
			throw new IllegalArgumentException("횟수는 1이상 이어야 합니다.");
		}
	}

	private boolean isNotNumber(final String value) {
		return value.chars().anyMatch(ch -> !Character.isDigit(ch));
	}

	private boolean isUnderOne(final String value) {
		return Integer.parseInt(value) < ONE;
	}
}
