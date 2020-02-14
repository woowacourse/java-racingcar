package racingcar.domian;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_LIMIT_NUMBER = 10;
    private static final Random random = new Random();

    private RandomNumberGenerator() {}

    public static int generateRandom() {
        return random.nextInt(RANDOM_LIMIT_NUMBER);
    }
}
