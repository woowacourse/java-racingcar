package domain;

import java.util.Random;

public class NumberGenerator {
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final Random RANDOM = new Random();

    private NumberGenerator() {
    }

    public static int generateRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
