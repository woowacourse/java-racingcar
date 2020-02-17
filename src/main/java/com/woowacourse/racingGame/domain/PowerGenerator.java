package com.woowacourse.racingGame.domain;

import java.util.Random;

public class PowerGenerator {
	private static final int RANDOM_UPPER_BOUND = 10;

	public static Power generateRandomNumber() {
		Random random = new Random();
		random.setSeed(System.nanoTime());
		return Power.valueOf(random.nextInt(RANDOM_UPPER_BOUND));
	}
}
