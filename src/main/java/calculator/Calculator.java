package calculator;

import calculator.view.Output;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	private static final int CUSTOM_DELIMITER_PART = 1;
	private static final int NUMBER_PART = 2;
	public static final String EMPTY_VALUE = "0";

	public int splitAndSum(final String text) {
		String calculatorText = replaceEmpty(text);
		return sum(getSplitNumbers(calculatorText));
	}

	private String replaceEmpty(final String text) {
		if (isEmpty(text)) {
			Output.emptyValueOfSum();
			return EMPTY_VALUE;
		}
		return text;
	}

	private boolean isEmpty(final String text) {
		return text == null || text.trim().isEmpty();
	}

	private int[] getSplitNumbers(final String text) {
		String delimiter = ",|:";
		String splitText = text;

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			delimiter += "|" + m.group(CUSTOM_DELIMITER_PART);
			splitText = m.group(NUMBER_PART);
		}
		return stringToIntArray(splitText.split(delimiter));
	}

	private int[] stringToIntArray(final String[] strings) {
		return Arrays.stream(strings)
				.filter(this::isValidNumber)
				.map(Integer::parseInt)
				.mapToInt(Integer::intValue).toArray();
	}

	private boolean isValidNumber(final String string) {
		if (isEmpty(string)) {
			return false;
		}
		if (!isNumber(string)) {
			throw new IllegalArgumentException("숫자를 입력해주세요!");
		}
		return true;
	}

	private boolean isNumber(final String string) {
		return string.matches("[+-]?\\d*?(\\.\\d+)?");
	}

	private int sum(final int[] numbers) {
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

	private void checkNegative(final int number) {
		if (number < 0) {
			throw new RuntimeException("자연수를 입력해주세요.");
		}
	}
}
