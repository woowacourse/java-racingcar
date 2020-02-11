package tdd.calculator.domain;

import tdd.calculator.util.InputUtils;

public class PlusCalculator {
	private static final int DEFAULT_VALUE = 0;

	public static int calculate(final String value) {
		if (isBlank(value)) {
			return DEFAULT_VALUE;
		}
		return sum(InputUtils.splitValues(value));
	}

	private static boolean isBlank(String value) {
		return value == null || value.isBlank();
	}

	private static int sum(final String[] values) {
		int sum = DEFAULT_VALUE;
		for (final String value : values) {
			final int positive = new Positive(value).getPositive();
			sum += positive;
		}
		return sum;
	}
}
