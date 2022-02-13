package racingCar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingCar.utlis.Constants;

class CountValidatorTest {

	@Test
	public void 빈_문자열_입력된_경우() {
		String inputString = "";
		assertThatThrownBy(() -> {
			CountValidator.validateInput(inputString);
		}).isInstanceOf(Exception.class)
			.hasMessage(Constants.EXCEPTION_NULL_MESSAGE);
	}

	@Test
	public void 숫자가_아닐_경우() {
		String inputString = "a";
		assertThatThrownBy(() -> {
			CountValidator.validateInput(inputString);
		}).isInstanceOf(Exception.class)
			.hasMessage(Constants.EXCEPTION_NOT_NUMBER_MESSAGE);
	}

	@Test
	public void 제로_이하_수를_받은_경우() {
		int count = 0;
		assertThatThrownBy(() -> {
			CountValidator.validateInteger(count);
		}).isInstanceOf(Exception.class)
			.hasMessage(Constants.EXCEPTION_ZERO_MESSAGE);
	}

}