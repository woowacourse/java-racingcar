package com.woowacourse.racingGame.domain;

import java.util.Random;

public class RandomGenerator {
	private static final int RANDOM_UPPER_BOUND = 10;

	public static int generateRandomNumber() {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		return random.nextInt(RANDOM_UPPER_BOUND);
	}
}
