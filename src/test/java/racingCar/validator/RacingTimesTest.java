package racingCar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTimesTest {
	@Test
	@DisplayName("시도 횟수 숫자 이외의 값 입력")
	void isRightTimesNotNumberError() {
		assertThatThrownBy(() -> RacingCarValidator.isRightTimes("!"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("시도 횟수 정수가 아닌 실수값 입력")
	void isRightTimesNotIntegerError() {
		assertThatThrownBy(() -> RacingCarValidator.isRightTimes("1.5"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("시도 횟수 음수 값 입력")
	void isRightTimesNegativeNumberError() {
		assertThatThrownBy(() -> RacingCarValidator.isRightTimes("-2"))
			.isInstanceOf(RuntimeException.class);
	}
}
