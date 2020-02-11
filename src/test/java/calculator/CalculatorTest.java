package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * CalculatorTest.java
 * 계산기 기능 테스트 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        11 Feb 2020
 *
 */
public class CalculatorTest {
	@Test
	void isBlank_emptyOrNull_success() {
		int result = Calculator.calculate("");
		assertThat(result).isEqualTo(0);

		result = Calculator.calculate(null);
		assertThat(result).isEqualTo(0);
	}

	@Test
	void calculate_defaultDelimiter_success() {
		int result = Calculator.calculate("1:2");
		assertThat(result).isEqualTo(3);

		result = Calculator.calculate("1,2");
		assertThat(result).isEqualTo(3);
	}
}
