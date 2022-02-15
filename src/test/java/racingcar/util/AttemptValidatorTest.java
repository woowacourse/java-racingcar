package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import racingcar.validator.AttemptValidator;

public class AttemptValidatorTest {

	@Test
	public void 시도횟수_타입_정상() {
		AttemptValidator.checkFromInput("4");
	}

	@Test
	public void 시도횟수_타입_예외() {
		Assertions.assertThatThrownBy(() -> {
				AttemptValidator.checkFromInput("라라");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 숫자여야 합니다.");
	}

	@Test
	public void 시도횟수_범위_예외() {
		Assertions.assertThatThrownBy(() -> {
				AttemptValidator.checkFromInput("-1");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 1회 이상이어야 합니다.");
	}
}
