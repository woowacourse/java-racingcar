package tdd.calculator.domain;

public class Positive {
	private final int positive;

	public Positive(final String positive) {
		this(Integer.parseInt(positive));
	}

	public Positive(final int positive) {
		validate(positive);
		this.positive = positive;
	}

	private void validate(final int positive) {
		if (isZero(positive)) {
			throw new IllegalArgumentException("0을 입력할 수 없습니다.");
		}
		if (isNegative(positive)) {
			throw new RuntimeException("음수를 입력할 수 없습니다.");
		}
	}

	private boolean isZero(final int positive) {
		return positive == 0;
	}

	private boolean isNegative(final int positive) {
		return positive < 0;
	}

	public int getValue() {
		return positive;
	}
}
