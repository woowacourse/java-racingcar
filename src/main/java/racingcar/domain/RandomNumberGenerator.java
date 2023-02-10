package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
	private static final int RANDOM_MAX_INT_NUMBER = 10;
	private static final Random RANDOM = new Random();

	public int generateNumber() {
		return RANDOM.nextInt(RANDOM_MAX_INT_NUMBER);
	}
}
