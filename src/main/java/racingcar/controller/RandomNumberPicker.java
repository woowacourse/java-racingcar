package racingcar.controller;

import java.util.Random;

public class RandomNumberPicker implements NumberPicker {

	private static final int RANDOM_RANGE = 10;
	private final Random random;

	public RandomNumberPicker() {
		random = new Random();
		random.setSeed(System.currentTimeMillis());
	}

	@Override
	public int pickNumber() {
		return random.nextInt(RANDOM_RANGE);
	}
}
