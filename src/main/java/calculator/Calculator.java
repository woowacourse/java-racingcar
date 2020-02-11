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
	public static int calculate(String value) {
		if(isBlank(value)){
			return 0;
		}
		int result = 0;
		String[] numbers = value.split(":|,");
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}
		return result;
	}

	private static boolean isBlank(String value) {
		return value == null || value.isEmpty();
	}
}
