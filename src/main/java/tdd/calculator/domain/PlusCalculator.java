package tdd.calculator.domain;

import tdd.calculator.util.InputUtils;

public class PlusCalculator {
	public static int calculate(final String value) {
		if (isBlank(value)) {
			return 0;
		}
		return sum(InputUtils.splitValues(value));
	}

	private static boolean isBlank(String value) {
		return value == null || value.isBlank();
	}

	private static int sum(final String[] values) {
		int sum = 0;
		for (final String value : values) {
			final int positive = new Positive(value).getPositive();
			sum += positive;
		}
		return sum;
	}
}
