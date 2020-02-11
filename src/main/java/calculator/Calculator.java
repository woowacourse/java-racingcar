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

	public static int calculate(String value) {
		if (isBlank(value)) {
			return 0;
		}
		int result = 0;
		String[] numbers = value.split(DEFAULT_DELIMITER);
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}
		return result;
	}

	private static boolean isBlank(String value) {
		return value == null || value.isEmpty();
	}

	public static String[] splitCustomDelimiter(String value) {
		String delimiter = value.substring(DELIMITER_BEGIN_INDEX, DELIMITER_END_INDEX);
		String realValue = value.substring(value.indexOf('\n') + 1);
		return realValue.split(delimiter);
	}
}

