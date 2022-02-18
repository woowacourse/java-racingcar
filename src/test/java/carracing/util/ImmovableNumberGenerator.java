package carracing.util;

import carracing.utils.NumberGenerator;

public class ImmovableNumberGenerator implements NumberGenerator {
	private static final int IMMOVABLE_NUMBER = 3;

	@Override
	public int generate() {
		return IMMOVABLE_NUMBER;
	}
}
