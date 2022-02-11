package racingCar.utlis;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Util {

	public static int getRandomInteger() {
		return new Random().nextInt(Constants.RANDOM_MAX_BOUND_INTEGER);
	}

	public static int getMax(List<Integer> integers) {
		return Collections.max(integers);
	}
}
