package racingcar.utils;

import java.util.Random;

public class RandomGenerator {
	private static final int LIMIT = 10;

	private static Random random = new Random();

	public static int getRandomNumber() {
		return random.nextInt(LIMIT);
	}
}
