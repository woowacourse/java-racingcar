package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilTest {
	private static final int MIN = 0;
	private static final int MAX = 9;

	@Test
	@DisplayName("0~9사이의 수가 잘 생성되는 지")
	void randomNumberTest() {
		assertThat(RandomUtil.random() >= MIN && RandomUtil.random() <= MAX).isTrue();
	}
}