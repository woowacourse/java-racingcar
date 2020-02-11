package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

	@ParameterizedTest
	@CsvSource(value = {"1,2_3", "1:2_3", "1,2:3_6"}, delimiter = '_')
	void calculate_defaultDelimiter_success(String value, int expected) {
		int actual = Calculator.calculate(value);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void calculate_customDelimiter_success() {
		String[] s = Calculator.splitCustomDelimiter("//@\n1@2@3");
		assertThat(s).containsExactly("1", "2", "3");
	}
}
