package racingcar.domain.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.util.Constant;

class AttemptValidatorTest {

	@DisplayName("시도횟수 공백 테스트")
	@Test
	void attempt_empty() {
		assertThatThrownBy(() -> {
			AttemptValidator.attemptValid(" ");
		}).isInstanceOf(IllegalArgumentException.class).
			hasMessage(String.format(Constant.ATTEMPT_BLANK_ERROR_MESSAGE, "공백"));
	}

	@DisplayName("시도횟수 null 테스트")
	@Test
	void attempt_null() {
		assertThatThrownBy(() -> {
			AttemptValidator.attemptValid(null);
		}).isInstanceOf(NullPointerException.class).
			hasMessage(String.format(Constant.ATTEMPT_BLANK_ERROR_MESSAGE, "null"));
	}

	@DisplayName("시도횟수 문자 예외 테스트")
	@Test
	void attempt_number() {
		assertThatThrownBy(() -> {
			AttemptValidator.attemptValid("횟수");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(Constant.ATTEMPT_NUMERIC_ERROR_MESSAGE);
	}

	@DisplayName("시도횟수 음수 테스트")
	@Test
	void attempt_negative() {
		assertThatThrownBy(() -> {
			AttemptValidator.attemptValid("-1");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(Constant.ATTEMPT_NEGATIVE_ERROR_MESSAGE);
	}
}