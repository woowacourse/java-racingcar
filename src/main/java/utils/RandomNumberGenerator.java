package utils;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int UPPER_BOUND = 10;
    private static final Random rand = new Random();

    public static int generateRandomNumber() {
        return rand.nextInt(UPPER_BOUND);
    }
}
