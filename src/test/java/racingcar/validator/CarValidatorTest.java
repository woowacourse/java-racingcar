package racingcar.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarValidatorTest {

	@Test
	public void 자동차_개수가_2개이상인지_검사하는_동작이_작동하는지_검사() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			CarValidator.checkAccuracyOfCarNames(Arrays.asList(new String[]{"car"}));
		});
	}

	@Test
	public void 중복된_차가_2개이상_존재하는지_검사() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			CarValidator.checkAccuracyOfCarNames(Arrays.asList(new String[]{"car", "car"}));
		});
	}
}