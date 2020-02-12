package com.woowacourse.racingGame.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {
	private static final Integer LOWER_BOUND = 0;
	private static final Integer UPPER_BOUND = 9;

	@Test
	void generateRandomNumber_0부터_9사이의_랜덤_정수_생성() {
		int generatedNumber = RandomGenerator.generateRandomNumber();

		assertThat(generatedNumber).isBetween(LOWER_BOUND, UPPER_BOUND);
	}
}
