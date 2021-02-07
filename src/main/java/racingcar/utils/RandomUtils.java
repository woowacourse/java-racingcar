package racingcar.utils;

import java.util.Random;

public class RandomUtils {
    private static final int MAX_NUMBER = 9;
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int generateRandomNumber() {
        return RANDOM.nextInt(MAX_NUMBER);
    }
}