package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_NUMBER_BOUND = 10;

    public static int makeRandom() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
