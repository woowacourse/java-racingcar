package calculator;

import java.util.Arrays;

public class Calculator {
	public static final String COLON_DELIMITER = ":";
	public static final int ERROR = -1;

	public static int calculate(String input) {
		try {
			String[] values = Expression.getFinalExpression(input)
					.split(COLON_DELIMITER);
			return sum(values);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	private static int sum(String[] values) {
		return Arrays.stream(values)
				.mapToInt(Integer::parseInt)
				.sum();
	}
}
