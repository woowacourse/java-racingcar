package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

	@Test
	@DisplayName("1~9사이의 난수가 생성되는지 확인한다.")
	void getRandomNumber() {
		List<Integer> randomNumbers = RandomNumber.getRandomNumbers(4);

		randomNumbers.forEach((randomNumber) -> assertThat(checkRandomNumberInRange(randomNumber)).isTrue());
	}

	private boolean checkRandomNumberInRange(int random) {
		return 1 <= random && random <= 9;
	}
}