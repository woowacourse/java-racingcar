package calculator;

import java.util.Arrays;

public class Calculator {
	public static final String NUMBER_EXPRESSION = "[0-9]+";

	public static int calculate(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		String[] numbers = StringSplitter.split(input);
		validatePositiveNumberAndZero(numbers);
		return Arrays.stream(numbers)
			.mapToInt(Integer::parseInt)
			.sum();
	}

	public static void validatePositiveNumberAndZero(String[] inputs) {
		boolean isNotPositiveNumberAndZero = Arrays.stream(inputs)
			.anyMatch(input -> !input.matches(NUMBER_EXPRESSION));
		if (isNotPositiveNumberAndZero) {
			throw new RuntimeException("숫자가 아닌 값이나 음수(-) 입력으로 예외 발생");
		}
	}
}
