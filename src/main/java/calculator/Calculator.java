package calculator;

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
	public static final int DELIMITER_BEGIN_INDEX = 2;
	public static final int DELIMITER_END_INDEX = 3;
	public static final String DEFAULT_DELIMITER = "[:,]";
	public static final char DELIMITER_END_CHAR = '\n';
	public static final int START_INDEX = 0;

	public static int calculate(String value) {
		if (isBlank(value)) {
			return 0;
		}
		return plus(split(value));
	}

	private static String[] split(String value) {
		if (containDefaultDelimiter(value)) {
			return value.split(DEFAULT_DELIMITER);
		}
		return splitCustomDelimiter(value);
	}

	private static boolean containDefaultDelimiter(String value) {
		char c = value.charAt(START_INDEX);
		try {
			Integer.parseInt(Character.toString(c));
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

	private static boolean isBlank(String value) {
		return value == null || value.isEmpty();
	}

	public static String[] splitCustomDelimiter(String value) {
		String delimiter = value.substring(DELIMITER_BEGIN_INDEX, DELIMITER_END_INDEX);
		String realValue = value.substring(value.indexOf(DELIMITER_END_CHAR) + 1);
		return realValue.split(delimiter);
	}

	public static int plus(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			int tmp = Integer.parseInt(number);
			if (tmp < 0) {
				throw new RuntimeException();
			}
			result += tmp;
		}
		return result;
	}
}

