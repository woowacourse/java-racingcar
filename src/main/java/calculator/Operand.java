package calculator;

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
	public static final int MINIMUM_NUMBER = 0;
	public static final String EXCEPTION_NEGATIVE_NUMBER = "negative number is not able to use";
	public static final Operand ZERO = new Operand(0);

	private final int value;

	Operand(int value) {
		if (value < MINIMUM_NUMBER) {
			throw new IllegalArgumentException(EXCEPTION_NEGATIVE_NUMBER);
		}
		this.value = value;
	}

	Operand add(Operand number) {
		return new Operand(value + number.value);
	}

	public int getValue() {
		return value;
	}
}
