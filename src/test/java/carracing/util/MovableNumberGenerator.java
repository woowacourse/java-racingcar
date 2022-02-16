package carracing.util;

import carracing.utils.NumberGenerator;

public class MovableNumberGenerator implements NumberGenerator {
	private static final int MOVABLE_NUMBER = 9;

	@Override
	public int generate() {
		return MOVABLE_NUMBER;
	}
}
