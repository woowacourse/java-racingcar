package racingcar.Util;

import java.util.Random;

/**
 * 클래스 이름 : RandomNumberUtils.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * * @version 1.0
 * <p>
 * 날짜 : 2020/02/15
 */

public class RandomNumberUtils {
	private static final int RANDOM_UPPER_LIMIT = 10;

	private static Random random = new Random();

	private RandomNumberUtils() {
	}

	public static int createRandomNumber() {
		return random.nextInt(RANDOM_UPPER_LIMIT);
	}


}
