package racingCar.utlis;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Util {
	public static final String NAME_REGEX = ",";
	private static final int RANDOM_MAX_BOUND_INTEGER = 10;

	public static int getRandomInteger() {
		return new Random().nextInt(RANDOM_MAX_BOUND_INTEGER);
	}

	public static int getMax(List<Integer> integers) {
		return Collections.max(integers);
	}

	public static String[] separate(String text) {
		return text.split(NAME_REGEX);
	}

	public static int convertToInteger(String count) {
		return Integer.parseInt(count);
	}
}
