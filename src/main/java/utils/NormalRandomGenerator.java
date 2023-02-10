package utils;

import java.util.Random;

public class NormalRandomGenerator {
    private final static Random random = new Random();
    private final static int RANDOM_RANGE = 10;

    public static int createRandomNumber() {
        return random.nextInt(RANDOM_RANGE);
    }
}
