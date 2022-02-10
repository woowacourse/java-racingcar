package racingcar;

public class RandomNumberGenerator implements NumberGenerator {
	private int maxBound;
	private int minBound;

	public RandomNumberGenerator(int maxBound, int minBound) {
		this.maxBound = maxBound;
		this.minBound = minBound;
	}

	@Override
	public int generate() {
		return random.nextInt(maxBound + 1 - minBound) + minBound;
	}
}
