package racingcar.util;

public class RandomUtil {
	public static final int BOUND = 10;

	public static int random() {
		return (int)(Math.random() * BOUND);
	}
}
