package calculator.utils.validator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputValidatorTest {

	@Test
	@DisplayName("커스텀 구분자가 입력된 경우")
	void customDelimiterExist() {
		assertThat(UserInputValidator.isCustomDelimiter("//;")).isTrue();
	}

	@Test
	@DisplayName("커스텀 구분자가 입력되지 않은 경우")
	void mixDelimiterTest() {
		assertThat(UserInputValidator.isCustomDelimiter("1,2:3")).isFalse();
	}
}