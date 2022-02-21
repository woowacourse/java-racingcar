package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import racingcar.util.Constant;

class AttemptTest {

	@Test
	void 같은_숫자_테스트() {
		Attempt attempt = new Attempt("5");
		assertTrue(attempt.isSame(5));
	}

	@DisplayName("시도횟수 공백 테스트")
	@Test
	void attempt_empty() {
		assertThatThrownBy(() -> {
			new Attempt(" ");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage("시도 횟수는 입력은 필수입니다. 이유 : For input string: \" \"");
	}

	@DisplayName("시도횟수 null 테스트")
	@Test
	void attempt_null() {
		assertThatThrownBy(() -> {
			new Attempt(null);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage("시도 횟수는 입력은 필수입니다. 이유 : null");
	}

	@DisplayName("시도횟수 문자 예외 테스트")
	@Test
	void attempt_number() {
		assertThatThrownBy(() -> {
			new Attempt("횟수");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage("시도 횟수는 입력은 필수입니다. 이유 : For input string: \"횟수\"");
	}

	@DisplayName("시도횟수 음수 테스트")
	@Test
	void attempt_negative() {
		assertThatThrownBy(() -> {
			new Attempt("-1");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(Constant.ATTEMPT_NEGATIVE_ERROR_MESSAGE);
	}
}