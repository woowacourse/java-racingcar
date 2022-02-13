package racingCar.utlis;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UtilTest {

	@Test
	public void 랜덤값_테스트() {
		for (int i = 0; i < 100; i++) {
			int result = Util.getRandomInteger();
			System.out.println("result :"  + result);
			assertThat(result).isBetween(0,9);
		}
	}

}