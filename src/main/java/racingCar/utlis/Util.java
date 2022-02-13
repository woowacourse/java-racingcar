package racingCar.utlis;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Util {
	private static final int RANDOM_MAX_BOUND_INTEGER = 10;

	public static int getRandomInteger() {
		return new Random().nextInt(RANDOM_MAX_BOUND_INTEGER);
	}

	public static int getMax(List<Integer> integers) {
		return Collections.max(integers);
	}
}
