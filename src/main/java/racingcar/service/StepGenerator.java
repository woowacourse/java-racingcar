package racingcar.service;

import java.util.Random;

public class StepGenerator implements StepPolicy {
	private static final int RANDOM_RANGE = 10;
	private static final int DRIVE_FLAG = 3;

	public boolean hasNext() {
		return generate() > DRIVE_FLAG;
	}

	private static int generate() {
		Random result = new Random();
		return result.nextInt(RANDOM_RANGE);
	}
}
