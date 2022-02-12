package racingcar.model;

import java.util.Random;

public class RandomNo {
	private static final int RANDOM_BOUND = 10;
	private static final Random random = new Random();

	public static int getNumber() {
		return random.nextInt(RANDOM_BOUND);
	}
}
