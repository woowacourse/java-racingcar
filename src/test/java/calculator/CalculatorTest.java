package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
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
	@DisplayName("빈 문자열 혹은 null값이 들어온 경우 0 반환")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"    ", "  ", " ", "\n", "\t"})
	void calculate_emptyOrNull_success(String input) {
		int result = Calculator.calculate(input);
		assertThat(result).isEqualTo(0);
	}

	@DisplayName("계산식의 덧셈 결과를 테스트한다. - 기본구분자")
	@ParameterizedTest
	@CsvSource(value = {"1,2_3", "1:2_3", "1,2:3_6"}, delimiter = '_')
	void calculate_defaultDelimiter_success(String value, int expected) {
		int actual = Calculator.calculate(value);
		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("계산식의 덧셈 결과를 테스트한다. - 커스텀구분자")
	@Test
	void calculate_customDelimiter_success() {
		assertThat(Calculator.calculate("//@\n1@2@3")).isEqualTo(6);
	}

	@DisplayName("숫자 이외의 값, 음수를 입력할 경우 RuntimeException을 throw 한다. - 기본구분자")
	@ParameterizedTest
	@ValueSource(strings = {"q:q:q:q:q:q:q:q:q", "1:-5"})
	void Given_defaultDelimiter_When_NaN_Then_runtimeException(String input) {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(
			() -> Calculator.calculate(input)
		);
	}

	@DisplayName("숫자 이외의 값, 음수를 입력할 경우 RuntimeException을 throw 한다. - 커스텀구분자")
	@ParameterizedTest
	@ValueSource(strings = {"//;\na;b;c", "//;\n1;2;-5", "//\n1;2", "//;\n1:2;-5"})
	void Given_customDelimiter_When_NaN_Then_runtimeException(String input) {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(
			() -> Calculator.calculate(input)
		);
	}

	@DisplayName("정의되지 않은 구분자 사용시 RuntimeException을 throw 한다. - 기본구분자")
	@ParameterizedTest
	@ValueSource(strings = {"1:2;3", "10:20.30"})
	void Given_defaultDelimiter_When_undefinedDelimiter_Then_runtimeException(String value) {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(
			() -> Calculator.calculate(value)
		);
	}

	@DisplayName("정의되지 않은 구분자를 사용하거나 포맷을 지키지 않았을 시 RuntimeException을 throw 한다. - 커스텀구분자")
	@ParameterizedTest
	@ValueSource(strings = {"//;\na;b.c", "//*\n1:2:5", "//;1;2;3", "/;\n1;2;3", "//;1;2;3"})
	void Given_customDelimiter_When_undefinedDelimiter_Then_runtimeException(String input) {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(
			() -> Calculator.calculate(input)
		);
	}
}
