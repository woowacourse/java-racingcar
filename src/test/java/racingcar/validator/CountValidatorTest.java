package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountValidatorTest {

	@Test
	public void 빈_문자열_입력된_경우() {
		String inputString = "";
		assertThatThrownBy(() -> {
			CountValidator.checkInputString(inputString);
		}).hasMessage("시도할 횟수가 입력되지 않았습니다.");
	}

	@Test
	public void 숫자가_아닐_경우() {
		String inputString = "a";
		assertThatThrownBy(() -> {
			CountValidator.checkInputString(inputString);
		}).hasMessage("숫자가 아닌 값이 입력되었습니다.");
	}

	@Test
	public void 경기를_진행하지_못하는_경우() {
		int count = 0;
		assertThatThrownBy(() -> {
			CountValidator.checkCountIsZero(count);
		}).hasMessage("0회 이하는 게임을 진행할 수 없습니다.");
	}

}