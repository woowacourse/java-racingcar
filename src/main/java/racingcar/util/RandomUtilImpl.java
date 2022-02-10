package racingcar.util;

import java.util.Random;

public class RandomUtilImpl implements RandomUtil {

	private static final Random random = new Random();

	@Override
	public int generate(int bound) {
		return random.nextInt(bound);
	}
}
