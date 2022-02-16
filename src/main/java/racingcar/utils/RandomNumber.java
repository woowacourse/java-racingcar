package racingcar.utils;

import java.util.Random;

public abstract class RandomNumber {

	private final static int MAX_EXCLUSIVE = 9;

	public static int getRandomNumber() {
		final Random random = new Random();
		return random.nextInt(MAX_EXCLUSIVE) + 1;
	}

}
