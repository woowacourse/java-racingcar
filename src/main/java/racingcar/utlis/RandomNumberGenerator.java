package racingcar.utlis;

import java.util.Random;

public class RandomNumberGenerator {

	private static final int MAX_RANDOM_NUMBER = 9;
	private static final Random random = new Random();

	public static int getRandomInt() {
		return random.nextInt(MAX_RANDOM_NUMBER);
	}

}
