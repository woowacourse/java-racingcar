package calculator;

import java.util.Arrays;

public class StringCalculator {

	private static final String DELIMITER = ",";

	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		return Arrays.stream(input.split(DELIMITER))
			.mapToInt(Integer::parseInt)
			.sum();
	}
}
