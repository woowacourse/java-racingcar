package calculator;

import java.util.Arrays;

public class StringCalculator {

	public static int splitAndSum(String input) {
		if (isBlank(input)) {
			return 0;
		}
		return sum(split(input));
	}

	public static boolean isBlank(String input) {
		return input == null || input.isEmpty();
	}

	public static int sum(int[] numbers) {
		return Arrays.stream(numbers)
			.sum();
	}

	public static int[] split(String input) {
		return Arrays.stream(input.split(","))
			.mapToInt(Integer::parseInt)
			.toArray();
	}
}
