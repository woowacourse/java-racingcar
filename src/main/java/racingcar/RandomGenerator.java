package racingcar;

import java.util.Random;

public class RandomGenerator {

    private static final int MAX_RANDOM_NUMBER = 10;

    private RandomGenerator() {
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
