package racingcar.util;

import java.util.Random;

public class RandomGenerator {
	private static final Random random = new Random();

	public static int generateNumber(int min, int max) {
		if (min == max) {
			return min;
		}
		return min + random.nextInt(max - min);
	}
}