package racingcar.utlis;

import java.util.Random;

public class RandomNumberGenerator {

	private static final int MAX_RANDOM_NUMBER = 9;

	public static int getRandomInt() {
		Random random = new Random();
		return random.nextInt(MAX_RANDOM_NUMBER);
	}

}
