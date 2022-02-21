package racingcar.util;

public class RandomUtil {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;

    private RandomUtil() {
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1));
    }
}
