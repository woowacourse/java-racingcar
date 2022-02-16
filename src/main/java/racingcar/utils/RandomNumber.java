package racingcar.utils;

import java.util.Random;

public class RandomNumber {

	private static final int MAX_EXCLUSIVE = 10;

	private static final Random random = new Random();
	private static RandomNumber instance;

	private RandomNumber() {}

	public static RandomNumber getInstance() {
		if (instance == null) {
			instance = new RandomNumber();
		}
		return instance;
	}

	public int getRandomNumber() {
		return random.nextInt(MAX_EXCLUSIVE);
	}
}
