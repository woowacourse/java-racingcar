package racingCar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingTimeValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	@DisplayName("정상 시도 횟수")
	void isRightLength(String input) {
		assertThatCode(() -> RacingCarTimeValidator.isRightTimes(input)).doesNotThrowAnyException();
	}

	@Test
	@DisplayName("시도 횟수 숫자 이외의 값 입력")
	void isRightTimesNotNumberError() {
		assertThatThrownBy(() -> RacingCarTimeValidator.isRightTimes("!"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("시도 횟수 정수가 아닌 실수값 입력")
	void isRightTimesNotIntegerError() {
		assertThatThrownBy(() -> RacingCarTimeValidator.isRightTimes("1.5"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("시도 횟수 음수 값 입력")
	void isRightTimesNegativeNumberError() {
		assertThatThrownBy(() -> RacingCarTimeValidator.isRightTimes("-2"))
			.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("시도 회수 입력이 비어있거나 null일때 에러")
	void isRightLengthEmptyName(String input) {
		assertThatThrownBy(() -> RacingCarTimeValidator.isRightTimes(input))
			.isInstanceOf(RuntimeException.class);
	}
}
