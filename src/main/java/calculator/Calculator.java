package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	private static final int WRONG_VALUE_RESULT = 0;
	private static final int CUSTOM_DELIMITER_PART = 1;
	private static final int NUMBER_PART = 2;

	public int splitAndSum(String text) {
		if (isEmpty(text)) {
			return WRONG_VALUE_RESULT;
		}
		return sum(getSplitNumbers(text));
	}

	private boolean isEmpty(String text) {
		return text == null || text.trim().isEmpty();
	}

	private int[] getSplitNumbers(String text) {
		String delimiter = ",|:";

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			delimiter += "|" + m.group(CUSTOM_DELIMITER_PART);
			text = m.group(NUMBER_PART);
		}
		return stringToIntArray(text.split(delimiter));
	}

	private int[] stringToIntArray(String[] strings) {
		return Arrays.stream(strings)
				.filter(this::isValidNumber)
				.map(Integer::parseInt)
				.mapToInt(Integer::intValue).toArray();
	}

	private boolean isValidNumber(String string) {
		if (isEmpty(string)) {
			return false;
		}
		if (!isNumber(string)) {
			throw new IllegalArgumentException("숫자를 입력해주세요!");
		}
		return true;
	}

	private boolean isNumber(String string) {
		return string.matches("[+-]?\\d*?(\\.\\d+)?");
	}

	private int sum(int[] numbers) {
		if (numbers.length == 1) {
			return numbers[0];
		}
		int result = 0;
		for (int i : numbers) {
			checkNegative(i);
			result += i;
		}
		return result;
	}

	private void checkNegative(int number) {
		if (number < 0) {
			throw new RuntimeException("자연수를 입력해주세요.");
		}
	}
}
