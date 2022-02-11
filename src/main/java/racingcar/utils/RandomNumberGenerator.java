package racingcar.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

    private static final int MIN_INCLUSIVE = 0;
    private static final int MAX_EXCLUSIVE = 10;

    public static int generate() {
        return ThreadLocalRandom.current().nextInt(MIN_INCLUSIVE, MAX_EXCLUSIVE);
    }
}
