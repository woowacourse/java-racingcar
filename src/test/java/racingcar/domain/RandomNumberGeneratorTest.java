package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
	final NumberGenerator numberGenerator = new RandomNumberGenerator();

	@DisplayName("랜덤 넘버 생성 기능 테스트")
	@RepeatedTest(10)
	void generateRandomNumberTest() {
		int generatedRandomNumber = numberGenerator.generateNumber();
		assertThat(generatedRandomNumber).isBetween(0, 9);
	}
}
