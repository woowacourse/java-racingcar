package tdd.calculator.domain;

public class Positive {
	private static final int INDEX_OF_MINUS_SIGN = 0;
	private static final char MINUS_SIGN = '-';

	private final int positive;

	public Positive(final String value) {
		if (isNegative(value) || isNotNumber(value)) {
			throw new RuntimeException();
		}
		positive = Integer.parseInt(value);
	}

	private boolean isNegative(final String value) {
		return value.charAt(INDEX_OF_MINUS_SIGN) == MINUS_SIGN;
	}

	private boolean isNotNumber(final String value) {
		return value.chars()
				.anyMatch(ch -> !Character.isDigit(ch));
	}

	public int getPositive() {
		return positive;
	}
}
