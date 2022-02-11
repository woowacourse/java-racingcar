package racingcar.util;

public class BoundedRandomNumberGenerator implements RandomNumberGenerator {
	private int maxBound;
	private int minBound;

	public BoundedRandomNumberGenerator(int maxBound, int minBound) {
		this.maxBound = maxBound;
		this.minBound = minBound;
	}

	@Override
	public int generate() {
		return random.nextInt(maxBound + 1 - minBound) + minBound;
	}
}
