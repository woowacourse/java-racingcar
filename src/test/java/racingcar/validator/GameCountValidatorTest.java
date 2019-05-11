package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameCountValidatorTest {

	@Test
	public void 입력값이_정수가_아닌_문자일_때_예외발생하는지_검사() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			GameCountValidator.checkAccuracyOfGameCount("e");
		});
	}
}