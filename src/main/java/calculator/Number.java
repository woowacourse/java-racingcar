package calculator;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Number.java
 * 000 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        11 Feb 2020
 *
 */
public class Number {
	public static final Number ZERO = new Number(0);

	private final int value;

	Number(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("not a positive");
		}
		this.value = value;
	}

	Number add(Number number) {
		return new Number(value + number.value);
	}

	public int getValue() {
		return value;
	}
}
