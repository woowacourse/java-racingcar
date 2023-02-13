package domain.strategy;

import java.util.Random;

public class RandomNumberStrategy {

	private static final int UPPER_BOUND = 10;
	private static final int THRESHOLD = 4;
	private static final Random random = new Random();

	public boolean movable() {
		int power = random.nextInt(UPPER_BOUND);
		return power >= THRESHOLD;
	}
}
