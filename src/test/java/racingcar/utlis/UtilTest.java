package racingcar.utlis;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UtilTest {

	@Test
	public void 랜덤값_테스트() {
		assertThat(RandomNumberGenerator.getRandomInt()).isBetween(0,9);
	}

}