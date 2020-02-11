package calculator;

import java.util.Arrays;

public class Calculator {
	public static int calculate(String s) {
		String delimiter = Delimiter.getDelimiter(s);
		String[] values = s.split(delimiter);

		return sum(values);
	}

	private static int sum(String[] values) {
		return Arrays.stream(values)
				.mapToInt(Integer::parseInt)
				.sum();
	}
}
