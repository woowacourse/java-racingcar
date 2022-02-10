package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {
	@Test
	@DisplayName("1~9사이의 난수가 생성되는지 확인한다.")
	void getRandomNumber() {
		RandomNumber randomNumber = new RandomNumber();
		int random = randomNumber.getRandomNumber();
		assertThat(checkRandomNumberInRange(random)).isTrue();
	}

	private boolean checkRandomNumberInRange(int random) {
		return 1 <= random && random <= 9;
	}
}