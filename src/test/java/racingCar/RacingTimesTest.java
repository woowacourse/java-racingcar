package racingCar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingCar.validator.RacingCarValidator;

public class RacingTimesTest {
	@Test
	void 시도_횟수_숫자_이외의_값_에러() {
		assertThatThrownBy(() -> RacingCarValidator.isRightTimes("!"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 시도_횟수_정수가_아닌_실수값_에러() {
		assertThatThrownBy(() -> RacingCarValidator.isRightTimes("1.5"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 시도_횟수_음수_값_에러() {
		assertThatThrownBy(() -> RacingCarValidator.isRightTimes("-2"))
			.isInstanceOf(RuntimeException.class);
	}
}
