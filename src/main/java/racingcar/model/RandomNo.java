package racingcar.model;

import java.util.Random;

public class RandomNo {
	private final Random random;
	public RandomNo() {
		random = new Random();
	}

	public int getNumber() {
		return random.nextInt(10);
	}
}
