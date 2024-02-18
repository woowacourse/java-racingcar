package utils;

import java.util.Random;

public class RandomNumberGenerator {
	private static final Random random = new Random();

	private RandomNumberGenerator() {
	}

	/**
	 * @param endInclusive 최댓값
	 * @return 0 이상 endInclusive 이하의 랜덤 정수
	 */
	public static int generateNumberUpTo(int endInclusive) {
		return random.nextInt(endInclusive + 1);
	}
}
