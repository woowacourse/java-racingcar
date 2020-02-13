package racing.controller;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
	private static final int RANDOM_MIN = 0;
	private static final int RANDOM_MAX = 9;

	public static int randomGenerate() {
		return ThreadLocalRandom.current()
			.ints(RANDOM_MIN, RANDOM_MAX)
			.limit(1)
			.findAny()
			.orElse(RANDOM_MIN);
	}
}
