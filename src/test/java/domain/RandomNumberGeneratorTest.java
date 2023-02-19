package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	private RandomNumberGenerator randomNumberGenerator;

	@BeforeEach
	void setUp() {
		randomNumberGenerator = new RandomNumberGenerator();
	}

	@Test
	@DisplayName("0 ~ 9사이의 랜덤값 생성하는 기능 테스트")
	void generate() {
		assertAll(
			() -> assertThat(randomNumberGenerator.generate()).isGreaterThanOrEqualTo(0),
			() -> assertThat(randomNumberGenerator.generate()).isLessThanOrEqualTo(9)
		);
	}
}
