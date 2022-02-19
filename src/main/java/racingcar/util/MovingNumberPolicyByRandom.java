package racingcar.util;

import java.util.Random;

public class MovingNumberPolicyByRandom implements MovingNumberPolicy {

	private static final int RANDOM_VALUE_RANGE = 10;

	private static final Random random = new Random();

	@Override
	public int generate() {
		return random.nextInt(RANDOM_VALUE_RANGE);
	}
}
