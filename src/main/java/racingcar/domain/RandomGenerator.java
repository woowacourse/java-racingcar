package racingcar.domain;

public class RandomGenerator {
	private static final int RANDOM_RANGE = 10;

	public static int generateRandom() {
		return (int)(Math.random() * RANDOM_RANGE);
	}
}
