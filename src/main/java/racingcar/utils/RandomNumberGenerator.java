package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {

	private static final Random RANDOM = new Random();

	public static int generateRandomNumber() {
		return RANDOM.nextInt(10);
	}
}
