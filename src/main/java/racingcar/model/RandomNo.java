package racingcar.model;

import java.util.Random;

public class RandomNo {
	private static final int RANDOM_BOUND = 10;
	private final Random random;
	public RandomNo() {
		random = new Random();
	}

	public int getNumber() {
		return random.nextInt(RANDOM_BOUND);
	}
}
