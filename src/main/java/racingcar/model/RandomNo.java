package racingcar.model;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNo {
	private static final int RANDOM_BOUND = 10;
	private final ThreadLocalRandom random;

	public RandomNo() {
		random = ThreadLocalRandom.current();
	}

	public int getNumber() {
		return random.nextInt(RANDOM_BOUND);
	}
}
