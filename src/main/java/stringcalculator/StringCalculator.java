package stringcalculator;

import static stringcalculator.Splitter.*;

import java.util.Arrays;

public class StringCalculator {
	public static final String ERROR_NEGATIVE_NUMBER_MESSAGE = "음수의 값이 입력되었습니다. 양수를 입력하세요.";
	public static final String ERROR_NOT_NUMBER_MESSAGE = "숫자 이외의 값이 입력되었습니다. 숫자를 입력하세요.";

	public int splitAndSum(String input) {
		if (validNullOrBlank(input)) {
			return 0;
		}
		return this.sum(split(input));
	}

	private int sum(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(this::mapToInt).sum();
	}

	private boolean validNullOrBlank(String input) {
		return input == null || input.isBlank();
	}

	private int mapToInt(String number) {
		try {
			int i = Integer.parseInt(number);
			if (i < 0) {
				throw new RuntimeException(ERROR_NEGATIVE_NUMBER_MESSAGE);
			}
			return i;
		} catch (NumberFormatException e) {
			throw new RuntimeException(ERROR_NOT_NUMBER_MESSAGE);
		}
	}
}
