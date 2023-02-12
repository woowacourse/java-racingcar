package racingcar.domain.number;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("랜덤 넘버 ")
class RandomNumberGeneratorTest {
	final NumberGenerator numberGenerator = new RandomNumberGenerator();

	@DisplayName("숫자 생성 성공 테스트")
	@RepeatedTest(10)
	void generateRandomNumberTest() {
		int generatedRandomNumber = numberGenerator.generateNumber();
		assertThat(generatedRandomNumber).isBetween(0, 9);
	}
}