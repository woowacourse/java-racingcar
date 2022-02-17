package racingCar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarNameTest {

	@Test
	@DisplayName("자동차 이름 6자 이상 입력")
	void isRightLengthOver6letter() {
		assertThatThrownBy(() -> RacingCarValidator.isRightLength("techCourse"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("자동차 이름 공백 에러")
	void isRightLengthEmptyName() {
		assertThatThrownBy(() -> RacingCarValidator.isRightLength(""))
			.isInstanceOf(RuntimeException.class);
	}
}
