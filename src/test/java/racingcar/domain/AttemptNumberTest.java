package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptNumberTest {

	@Test
	@DisplayName("시도횟수 타입 정상")
	public void correctTest() {
		AttemptNumber.of(1);
		AttemptNumber.of("1");
	}

	@Test
	@DisplayName("시도횟수 타입 예외")
	public void typeErrorTest() {
		Assertions.assertThatThrownBy(() -> {
				AttemptNumber.of("라라");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 숫자여야 합니다.");
	}

	@Test
	@DisplayName("시도횟수 범위 예외")
	public void rangeErrorTest() {
		Assertions.assertThatThrownBy(() -> {
				AttemptNumber.of("-1");
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 1회 이상이어야 합니다.");
	}
}
