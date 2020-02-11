package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

	@DisplayName("계산식을 문자열 배열을 테스트한다. - 커스텀구분자 ")
	@Test
	void splitCustomDelimiter_customDelimiter_success() {
		String[] s = Calculator.splitCustomDelimiter("//@\n1@2@3");
		assertThat(s).containsExactly("1", "2", "3");
	}

	@DisplayName("계산식의 덧셈 결과를 테스트한다. - 커스텀구분자")
	@Test
	void calculate_customDelimiter_success() {
		assertThat(Calculator.calculate("//@\n1@2@3")).isEqualTo(6);
	}

	@DisplayName("숫자 이외의 값을 입력할 경우 RuntimeException을 throw 한다. - 기본구분자")
	@ParameterizedTest
	@ValueSource(strings = {"q:q:q:q:q:q:q:q:q", "1:-5"})
	void checkRuntimeException_NaN_success(String input) {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(
			() -> Calculator.calculate(input)
		);
	}

	@DisplayName("숫자 이외의 값을 입력할 경우 RuntimeException을 throw 한다. - 커스텀구분자")
	@ParameterizedTest
	@ValueSource(strings = {"//;\na;b;c", "//;\n1;2;-5", "//\n1;2", "//;\n1:2;-5"})
	void checkRuntimeException_NaN_success1(String input) {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(
			() -> Calculator.calculate(input)
		);
	}



}
