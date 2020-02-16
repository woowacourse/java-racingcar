package racingcar.utils;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {
	private static final int LIMIT = 10;

	private Random random = new Random();

	@Override
	public int getNumber() {
		return random.nextInt(LIMIT);
	}
}
