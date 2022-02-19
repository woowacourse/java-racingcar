package racingCar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarNameValidatorTest {
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "aa,bb,cc"})
	@DisplayName("자동차 이름 입력 정상 입력")
	void isRightInput(String input) {
		assertThatCode(() -> RacingCarNameValidator.isRightInput(input)).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@ValueSource(strings = {" ", "  ", "   "})
	@DisplayName("자동차 이름 입력 공백 에러")
	void isRightInputBlank(String input) {
		assertThatThrownBy(() -> RacingCarNameValidator.isRightInput(input))
			.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"*", "^%&", "#!@!"})
	@DisplayName("자동차 이름 입력 특수문자 에러")
	void isRightInputSpecialLetter(String input) {
		assertThatThrownBy(() -> RacingCarNameValidator.isRightInput(input))
			.isInstanceOf(RuntimeException.class);
	}
	@ParameterizedTest
	@ValueSource(strings = {"runa", "dun"})
	@DisplayName("정상 자동차 이름")
	void isRightLength(String input) {
		assertThatCode(() -> RacingCarNameValidator.isRightLength(input)).doesNotThrowAnyException();
	}

	@Test
	@DisplayName("자동차 이름 6자 이상 에러")
	void isRightLengthOver6letter() {
		assertThatThrownBy(() -> RacingCarNameValidator.isRightLength("techCourse"))
			.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("자동차 이름이 비어있거나 null일때 에러")
	void isRightLengthEmptyName(String input) {
		assertThatThrownBy(() -> RacingCarNameValidator.isRightLength(input))
			.isInstanceOf(RuntimeException.class);
	}
}
