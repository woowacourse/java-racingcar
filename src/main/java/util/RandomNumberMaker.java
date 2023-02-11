package util;

import java.util.Random;

public class RandomNumberMaker {
	private static final int BOUND = 10;
	private static final Random random = new Random();

	public static int makeNumber() {
		return random.nextInt(BOUND);
	}
}
