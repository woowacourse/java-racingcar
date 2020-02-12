package tdd.calculator.domain;

public class Positive {
	private static final int INDEX_OF_MINUS_SIGN = 0;
	private static final char MINUS_SIGN = '-';

	private final int positive;

	public Positive(final String positive) {
		validate(positive);
		this.positive = Integer.parseInt(positive);
	}

	private void validate(final String positive) {
		if (isNotNumber(positive)) {
			throw new RuntimeException("숫자가 아닌 문자를 입력할 수 없습니다.");
		}
		if (isNegative(positive)) {
			throw new RuntimeException("음수를 입력할 수 없습니다.");
		}
	}

	private boolean isNegative(final String positive) {
		return positive.charAt(INDEX_OF_MINUS_SIGN) == MINUS_SIGN;
	}

	private boolean isNotNumber(final String positive) {
		return positive.chars()
				.anyMatch(ch -> !Character.isDigit(ch));
	}

	public int getPositive() {
		return positive;
	}
}
