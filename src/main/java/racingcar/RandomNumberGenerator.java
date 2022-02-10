package racingcar;

public class RandomNumberGenerator implements NumberGenerator {
	private final int MAX_BOUND = 9;
	private final int MIN_BOUND = 0;

	@Override
	public int generate() {
		return random.nextInt(MAX_BOUND + 1 - MIN_BOUND) - MIN_BOUND;
	}
}
