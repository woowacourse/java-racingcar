package com.woowacourse.stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final int ZERO = 0;
	private static final String DELIMITERS = "[:,]";
	private static final Pattern CUSTOM_REGEX = Pattern.compile("//(.)\n(.*)");

	// TODO : 실행하는 main문이 없는 경우, private 생성자를 만들어 제한을 둬야 함.

	private StringCalculator() {
	}

	public static int calculate(final String value) {
		if (isNullOrEmpty(value)) {
			return 0;
		}
		return calculateSum(splitByDelimiter(value));
	}

	private static int calculateSum(String[] values) {
		int calculateResult = ZERO;

		for (String number : values) {
			final int parsedNumber = Integer.parseInt(number);

			checkNegative(parsedNumber);
			calculateResult += parsedNumber;
		}
		return calculateResult;
	}

	private static void checkNegative(final int parsedNumber) {
		if (parsedNumber < ZERO) {
			throw new RuntimeException();
		}
	}

	private static boolean isNullOrEmpty(final String value) {
		return value == null || value.isEmpty();
	}

	private static String[] splitByDelimiter(final String value) {
		Matcher matcher = CUSTOM_REGEX.matcher(value);

		if (matcher.find()) {
			final String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}
		return value.split(DELIMITERS);
	}
}
