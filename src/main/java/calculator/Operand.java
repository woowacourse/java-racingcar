package calculator;

import java.util.HashMap;
import java.util.Map;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Number.java
 * 계산기 피연산 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        11 Feb 2020
 *
 */
public class Operand {
	private static final int MINIMUM_NUMBER = 0;
	private static final String EXCEPTION_NEGATIVE_NUMBER = "negative number is not able to use";
	private static final Map<Integer, Operand> operandCache;

	static {
		operandCache = new HashMap<>();
		for (int i = 0; i < 256; i++) {
			operandCache.put(i, new Operand(i));
		}
	}

	private final int value;

	private Operand(int value) {
		if (value < MINIMUM_NUMBER) {
			throw new IllegalArgumentException(EXCEPTION_NEGATIVE_NUMBER);
		}
		this.value = value;
	}

	static Operand valueOf(int value) {
		if (operandCache.containsKey(value)) {
			return operandCache.get(value);
		}
		return new Operand(value);
	}

	Operand add(String number) {
		return add(Integer.parseInt(number));
	}

	private Operand add(int number) {
		return valueOf(value + number);
	}

	public int getValue() {
		return value;
	}
}
