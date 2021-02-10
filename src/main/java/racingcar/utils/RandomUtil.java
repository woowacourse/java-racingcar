package racingcar.utils;

import java.util.Random;

public class RandomUtil {
    private static final int MAXIMUM_BOUND = 9;
    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int generateRandomNumber() {
        return RANDOM.nextInt(MAXIMUM_BOUND);
    }
}
