package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarUtilTest {
	public static final int MIN = 0;
	public static final int MAX = 9;

	@Test
	public void randomNumberTest() {
		assertThat(CarUtil.random() >= MIN && CarUtil.random() <= MAX).isTrue();
	}
}