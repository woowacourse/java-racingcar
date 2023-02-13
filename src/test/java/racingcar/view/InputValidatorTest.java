package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputValidatorTest {

	private static final int VALID_MIN = 1;
	private static final int VALID_MAX = 10;

	@Test
	@DisplayName("공백 입력 시 예외를 반환해야 한다.")
	void validateCarNamesTest() {
		final String input = " ";
		assertThatThrownBy(() -> InputValidator.validateBlankedNames(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Nested
	static class validateRoundCountTest {

		@ParameterizedTest
		@DisplayName("1이상 10 이하의 정수 문자열 입력은 검증을 통과해야 한다.")
		@MethodSource("validateRoundCountSuccessSource")
		public void validateRoundCountSuccessTest(String userInput) {
			assertDoesNotThrow(() -> InputValidator.validateRoundCount(userInput));
		}

		private static Stream<Arguments> validateRoundCountSuccessSource() {
			return Stream.of(
				Arguments.of(Integer.toString(VALID_MIN)),
				Arguments.of(Integer.toString(VALID_MAX))
			);
		}

		@ParameterizedTest
		@DisplayName("1미만 10 초과의 정수 문자열 입력은 검증에 실패해야 한다.")
		@MethodSource("validateRoundCountFailSource1")
		public void validateRoundCountFailTest1(String userInput) {
			assertThatThrownBy(() -> InputValidator.validateRoundCount(userInput))
				.isInstanceOf(IllegalArgumentException.class);
		}

		private static Stream<Arguments> validateRoundCountFailSource1() {
			return Stream.of(
				Arguments.of(Integer.toString(VALID_MIN - 2)),
				Arguments.of(Integer.toString(VALID_MIN - 1)),
				Arguments.of(Integer.toString(VALID_MAX + 1))
			);
		}

		@ParameterizedTest
		@DisplayName("정수로 변환이 불가한 문자열 입력은 검증에 실패해야 한다.")
		@MethodSource("validateRoundCountFailSource2")
		public void validateRoundCountFailTest2(String userInput) {
			assertThatThrownBy(() -> InputValidator.validateRoundCount(userInput))
				.isInstanceOf(IllegalArgumentException.class);
		}

		private static Stream<Arguments> validateRoundCountFailSource2() {
			return Stream.of(
				Arguments.of("--1"),
				Arguments.of("a")
			);
		}
	}
}
