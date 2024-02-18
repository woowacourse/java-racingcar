package util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    public int generate() {
        return new Random().nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
