package racingGame.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {
	@Test
	void generateRandomNumber_0부터_9사이의_랜덤_정수_생성(){
		int generatedNumber = RandomGenerator.generateRandomNumber();

		assertThat(generatedNumber).isBetween(0,9);
	}
}
