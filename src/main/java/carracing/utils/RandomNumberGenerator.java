package carracing.utils;

public class RandomNumberGenerator implements NumberGenerator{
	private static final int RANDOM_NUMBER_RANGE = 10;

	@Override
	public int generate() {
		return (int)(Math.random() * RANDOM_NUMBER_RANGE);
	}
}
