package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountValidatorTest {

	@Test
	public void 빈_문자열_입력된_경우() {
		String inputString = "";
		assertThatThrownBy(() -> {
			CountValidator.checkNull(inputString);
		}).isInstanceOf(Exception.class);
	}

	@Test
	public void 숫자가_아닐_경우() {
		String inputString = "a";
		assertThatThrownBy(() -> {
			CountValidator.checkNotNumber(inputString);
		}).isInstanceOf(Exception.class);
	}

	@Test
	public void 경기를_진행하지_못하는_경우() {
		int count = 0;
		assertThatThrownBy(() -> {
			CountValidator.checkCountIsZero(count);
		}).isInstanceOf(Exception.class);
	}

}