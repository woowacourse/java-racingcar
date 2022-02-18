package racingcar.util;

import java.util.Random;

public class MovingNumberPolicyByRandom implements MovingNumberPolicy {

	private static final Random random = new Random();

	@Override
	public int generate(int bound) {
		return random.nextInt(bound);
	}
}
