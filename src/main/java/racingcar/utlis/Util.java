package racingcar.utlis;

import java.util.Random;

public class Util {

	static final int MAX_RANDOM_NUMBER = 9;
	static final int MOVE_CRITERIA = 4;

	public static int getRandomInt() {
		Random random = new Random();
		return random.nextInt(MAX_RANDOM_NUMBER);
	}

	public static boolean isMove() {
		return getRandomInt() >= MOVE_CRITERIA;
	}
}
