package racingcar.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int nextNumber() {
        return RANDOM.nextInt(10);
    }
}