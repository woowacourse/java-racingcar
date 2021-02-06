package racingcar.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    private RandomUtils() {
    }

    public static int getRandomNumber() {
        return RANDOM_START + RANDOM.nextInt(RANDOM_END - RANDOM_START + 1);
    }

}