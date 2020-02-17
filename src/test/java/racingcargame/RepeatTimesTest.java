package racingcargame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.domain.RepeatTimes;

class RepeatTimesTest {
	@Test
	@DisplayName("생성자 테스트")
	void constructor() {
		Assertions.assertThat(new RepeatTimes("5")).isInstanceOf(RepeatTimes.class);
		Assertions.assertThat(new RepeatTimes("5").getRepeatTimes()).isEqualTo(5);
	}

	@Test
	@DisplayName("문자열을 입력한 경우")
	void parseTest() {
		Assertions.assertThatThrownBy(() -> new RepeatTimes("a"))
			.hasMessage("정수를 입력해주세요.");
	}

	@Test
	@DisplayName("음수를 입력한 경우")
	void negativeTest() {
		Assertions.assertThatThrownBy(() -> new RepeatTimes("-5"))
			.hasMessage("반복 횟수는 음수가 될 수 없습니다.");
	}
}
