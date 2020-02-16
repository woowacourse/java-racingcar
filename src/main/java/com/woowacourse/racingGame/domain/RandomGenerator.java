package com.woowacourse.racingGame.domain;

import java.util.Random;

public class RandomGenerator {
	private static final int RANDOM_UPPER_BOUND = 10;

	public static int generateRandomNumber() {
		Random random = new Random();
		// NOTE : 아래의 random.setSeed(System.currentTimeMillis())를 적용하면 모든 random값이 동일하게 생성되는 상황이 발생.
		// random.setSeed(System.currentTimeMillis());
		return random.nextInt(RANDOM_UPPER_BOUND);
	}
}
