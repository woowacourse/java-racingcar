package calculator;

import java.util.Arrays;

public class Calculator {

	public static final String COLON_DELIMITER = ":";

	public static int calculate(String input) {
		String[] values = Expression.getFinalExpression(input)
				.split(COLON_DELIMITER);

		return sum(values);
	}

	private static int sum(String[] values) {
		return Arrays.stream(values)
				.mapToInt(Integer::parseInt)
				.sum();
	}
}
