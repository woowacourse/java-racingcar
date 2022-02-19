package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.util.validator.AttemptValidator;

public class AttemptValidatorTest {

	@Test
	@DisplayName("시도횟수 타입 정상")
	public void correctTest() {
		AttemptValidator.check("4");
	}

	@Test
	@DisplayName("시도횟수 타입 예외")
	public void typeErrorTest() {
		Assertions.assertThatThrownBy(() -> {
				AttemptValidator.check("라라");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 숫자여야 합니다.");
	}

	@Test
	@DisplayName("시도횟수 범위 예외")
	public void rangeErrorTest() {
		Assertions.assertThatThrownBy(() -> {
				AttemptValidator.check("-1");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 1회 이상이어야 합니다.");
	}
}
