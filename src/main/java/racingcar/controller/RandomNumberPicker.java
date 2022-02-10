package racingcar.controller;

import java.util.Random;

public class RandomNumberPicker implements NumberPicker{

	@Override
	public int pickNumber() {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		return random.nextInt(10);
	}

}
