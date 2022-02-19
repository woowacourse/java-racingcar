package racingcar.service;

import java.util.Random;

public class RandomGenerator {
	private static final int RANDOM_RANGE = 10;

	public static int generate() {
		Random result = new Random();
		return result.nextInt(RANDOM_RANGE);
	}
}
