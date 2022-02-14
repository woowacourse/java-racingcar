package racingcar.domain.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttemptValidatorTest {
	private final AttemptValidator attemptValidator = new AttemptValidator();

	@DisplayName("시도횟수 공백 테스트")
	@Test
	void attempt_empty() {
		assertThatThrownBy(() -> {
			attemptValidator.checkBlank(" ", "시도횟수는 공백일 수 없습니다.");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("시도횟수 null 테스트")
	@Test
	void attempt_null() {
		assertThatThrownBy(() -> {
			attemptValidator.checkBlank(null, "시도횟수는 null 일 수 없습니다.");
		}).isInstanceOf(NullPointerException.class);
	}

	@DisplayName("시도횟수 문자 예외 테스트")
	@Test
	void attempt_number() {
		assertThatThrownBy(() -> {
			attemptValidator.attemptValid("횟수");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("시도횟수 음수 테스트")
	@Test
	void attempt_negative() {
		assertThatThrownBy(() -> {
			attemptValidator.attemptValid("-1");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}