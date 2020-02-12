package tdd.racingcar.domain;

import java.util.Random;

public class PowerFactory {
	private static final Random random = new Random();
	private static final int MAX_POWER_BOUND = 10;

	private PowerFactory() {}

	public static Power createRandomPower() {
		final int powerAmount = random.nextInt(MAX_POWER_BOUND);
		return new Power(powerAmount);
	}
}
