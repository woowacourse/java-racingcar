package racingcar.controller;

import java.util.Random;

import racingcar.constants.Constants;

public class RandomNumberPicker implements NumberPicker {

	private final Random random;

	public RandomNumberPicker() {
		random = new Random();
		random.setSeed(System.currentTimeMillis());
	}

	@Override
	public int pickNumber() {
		return random.nextInt(Constants.RANDOM_RANGE);
	}
}
