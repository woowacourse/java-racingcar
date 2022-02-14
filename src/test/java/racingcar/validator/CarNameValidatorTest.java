package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.validator.CarNameValidator.*;

public class CarNameValidatorTest {
	@Test
	@DisplayName("이름이 5자 초과일 경우")
	void longName() {
		Assertions.assertThatThrownBy(() -> validateName("summer"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_LONG_NAME);
	}

	@Test
	@DisplayName("빈 이름이 주어지거나 입력값이 없을 경우")
	void emptyName() {
		Assertions.assertThatThrownBy(() -> validateName(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_EMPTY_NAME);
	}

}