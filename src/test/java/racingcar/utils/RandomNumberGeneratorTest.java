package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@DisplayName("랜덤 넘버 생성 기능 테스트")
	@RepeatedTest(10)
	void generateRandomNumberTest() {
		int randomNumber = RandomNumberGenerator.generateRandomNumber();
		Assertions.assertThat(randomNumber).isBetween(0, 9);
	}
}