package racingcar.service;

import java.util.Random;

public class StepGenerator implements StepPolicy {
	private static final int RANDOM_RANGE = 10;

	public int generate() {
		Random result = new Random();
		return result.nextInt(RANDOM_RANGE);
	}
}
