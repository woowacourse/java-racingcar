package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundCountTest {

	@DisplayName("숫자가_아닐_경우")
	@Test
	public void testCountMatchNumber() {
		String input = "a";
		assertThatThrownBy(() -> {
			new RoundCount(input);
		}).hasMessage("숫자가 아닌 값이 입력되었습니다.");
	}

	@DisplayName("카운트가 0인 경우")
	@Test
	public void testCountOverZero() {
		String input = "0";
		assertThatThrownBy(() -> {
			new RoundCount(input);
		}).hasMessage("0회 이하는 게임을 진행할 수 없습니다.");
	}
}