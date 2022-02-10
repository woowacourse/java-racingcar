package racingcar.utils;

import java.util.Random;

public class RandomNumber {
	private final static int MAX_EXCLUSIVE = 9;

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(MAX_EXCLUSIVE) + 1;
	}
}
