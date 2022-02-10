package racingCar.utlis;

import java.util.Random;

public class Util {
	public static int getRandomInt() {
		Random random = new Random();
		return random.nextInt(9);
	}
}
