package racingcar.utils;

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
		InputValidation validation = mock(InputValidation.class);

		@DisplayName("옳바른 형식이면 통과한다.")
		@ParameterizedTest(name = "{index} {displayName} names={0}")
		@ValueSource(strings = {"pobi,crong,honux", "pobi"})
		void checkRightName(final String names) {
			validation.validateName(names);
			verify(validation).validateName(names);
		}
	}

}