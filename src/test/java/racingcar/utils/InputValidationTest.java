package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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
			InputValidation validation = mock(InputValidation.class);
			validation.validateName(names);
			verify(validation).validateName(names);
		}

		@DisplayName("5자리 이상의 문자열이 주어지면 exception이 발생한다.")
		@ParameterizedTest(name = "{index} {displayName} names={0}")
		@ValueSource(strings = {"pobi,crong,honuxxx", "pobixxxx"})
		void checkWrongName(final String names) {
			InputValidation validation = new InputValidation();
			assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> validation.validateName(names))
				.withMessageMatching("이름은 5자리 이하만 가능합니다.");
		}
	}

}