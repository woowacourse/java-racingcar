package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Calculator.java
 * 계산기 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        11 Feb 2020
 *
 */
public class Calculator {
	private static final String DEFAULT_DELIMITER = "[:,]";
	private static final Pattern DEFAULT_INPUT_PATTERN = Pattern.compile("-?[0-9]+([:,]-?[0-9]+)*");
	private static final Pattern CUSTOM_INPUT_PATTERN = Pattern.compile("//(.)\n(.*)");

	private static final String EXCEPTION_INAPPROPRIATE_CUSTOM_FORMAT = "inappropriate custom format";

	private Calculator() {
	}

	public static int calculate(String value) {
		if (isBlank(value)) {
			return 0;
		}
		return plus(split(value));
	}

	private static boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}

	private static String[] split(String value) {
		if (containDefaultDelimiter(value)) {
			return value.split(DEFAULT_DELIMITER);
		}
		return splitCustomDelimiter(value);
	}

	private static boolean containDefaultDelimiter(String value) {
		Matcher matcher = DEFAULT_INPUT_PATTERN.matcher(value);
		return matcher.matches();
	}

	private static String[] splitCustomDelimiter(String value) {
		Matcher matcher = CUSTOM_INPUT_PATTERN.matcher(value);
		if (!matcher.find()) {
			throw new IllegalArgumentException(EXCEPTION_INAPPROPRIATE_CUSTOM_FORMAT);
		}
		String customDelimiter = matcher.group(1);

		String expressions = matcher.group(2);
		return expressions.split(customDelimiter);
	}

	private static int plus(String[] numbers) {
		Operand result = Operand.valueOf(0);
		for (String number : numbers) {
			result = result.add(number);
		}
		return result.getValue();
	}
}