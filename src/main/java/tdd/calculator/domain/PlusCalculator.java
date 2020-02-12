package tdd.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tdd.calculator.util.InputUtils;

public class PlusCalculator {
	private static final int DEFAULT_VALUE = 0;

	public static int calculate(final String value) {
		if (isBlank(value)) {
			return DEFAULT_VALUE;
		}
		final List<Positive> positives = toPositives(InputUtils.splitValues(value));
		return sum(positives);
	}

	private static boolean isBlank(final String value) {
		return value == null || value.isBlank();
	}

	private static List<Positive> toPositives(final String[] values) {
		return Arrays.stream(values)
			.map(Positive::new)
			.collect(Collectors.toList());
	}

	private static int sum(final List<Positive> positives) {
		return positives.stream()
			.mapToInt(Positive::getPositive)
			.sum();
	}
}
