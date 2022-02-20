package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidation클래스 테스트")
class InputValidationTest {

	@Nested
	@DisplayName("이름 문자열이 주어졌을 때 ")
	class NameTest {

		@DisplayName("옳바른 형식이면 통과한다.")
		@ParameterizedTest(name = "{index} {displayName} names={0}")
		@ValueSource(strings = {"pobi,crong,honux", "pobi"})
		void checkRightName(final String names) {
			assertThatNoException().isThrownBy(() -> InputValidation.validateName(names));
		}

		@DisplayName("5자리 이상의 문자열이 주어지면 exception이 발생한다.")
		@ParameterizedTest(name = "{index} {displayName} names={0}")
		@ValueSource(strings = {"pobi,crong,honuxxx", "pobixxxx"})
		void checkWrongName(final String names) {
			assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> InputValidation.validateName(names))
				.withMessageMatching("이름은 5자리 이하만 가능합니다.");
		}
	}

	@Nested
	@DisplayName("반복할 횟수가 주어졌을 때")
	class RepeatTest {

		@DisplayName("올바른 반복 횟수면 통과한다")
		@ParameterizedTest(name = "{index} {displayName} repeats={0}")
		@ValueSource(strings = {"2", "10"})
		void checkRightRepeats(final String repeats) {
			assertThatNoException().isThrownBy(() -> InputValidation.validateName(repeats));
		}

		@DisplayName("잘못된 반복 횟수면 exception이 발생한다")
		@ParameterizedTest(name = "{index} {displayName} repeats={0}")
		@ValueSource(strings = {"-2", "1a0"})
		void checkWrongRepeats(final String repeats) {
			assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> InputValidation.validateRepeats(repeats))
				.withMessageMatching("반복횟수는 정수만 입력 가능합니다.");
		}
	}
}