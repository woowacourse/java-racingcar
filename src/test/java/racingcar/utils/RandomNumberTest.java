package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("RandomNumber 클래스를 테스트한다.")
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