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

	public static int[] generateNumbers(int cnt, int min, int max) {
		int[] numbers = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			numbers[i] = generateNumber(min, max);
		}
		return numbers;
	}
}