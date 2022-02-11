package racingCar.utlis;

import java.util.Random;

public class Util {

	public static int getRandomInteger() {
		return new Random().nextInt(Constants.RANDOM_MAX_BOUND_INTEGER);
	}
}
