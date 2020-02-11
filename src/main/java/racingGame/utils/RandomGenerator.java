package racingGame.utils;

import java.util.Random;

public class RandomGenerator {
	private static final int UPPER_BOUND = 10;

	public static int generateRandomNumber() {
		return new Random().nextInt(UPPER_BOUND);
	}
}
