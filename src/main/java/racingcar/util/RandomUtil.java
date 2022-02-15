package racingcar.util;

public class RandomUtil {

    public static final int RANDOM_RANGE = 10;

    private RandomUtil() {
    }

    public static int getRandomNumber() {
        return (int) Math.floor(Math.random() * RANDOM_RANGE);
    }
}
