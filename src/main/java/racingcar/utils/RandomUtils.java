package racingcar.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();
    private static final int START = 0;
    private static final int END = 10;

    private RandomUtils() {
    }

    public static int createRandomNumber() {
        return START + RANDOM.nextInt(END - START);
    }
}
