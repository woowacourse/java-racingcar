package utils;

import java.util.Random;

public class Randoms {
	private static final Random random = new Random();

	private Randoms() {
	}

	/**
	 * @param endInclusive 최댓값
	 * @return 0 이상 endInclusive 이하의 랜덤 정수
	 */
	public static int getRandomNumber(int endInclusive) {
		return random.nextInt(endInclusive + 1);
	}
}
