package racingcar.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    private RandomUtils() {
    }

    public static int nextInt() {
        return RANDOM.nextInt(BOUND);
    }

}
