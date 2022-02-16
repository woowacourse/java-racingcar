package racingCar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingCar.controller.RacingCarController;
import racingCar.validator.RacingCarValidator;

public class RacingCarNameTest {

	@Test
	void 자동차_이름_6자_에러() {
		assertThatThrownBy(() -> RacingCarValidator.isRightLength("techCourse"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 자동차_이름_공백_에러() {
		assertThatThrownBy(() -> RacingCarValidator.isRightLength(""))
			.isInstanceOf(RuntimeException.class);
	}
}
