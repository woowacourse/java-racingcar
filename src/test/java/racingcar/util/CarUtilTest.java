package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarUtilTest {
	@Test
	public void randomNumberTest() {
		assertThat(CarUtil.random() >= 0 && CarUtil.random() <= 9).isTrue();
	}
}