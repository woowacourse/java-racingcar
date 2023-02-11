package utils;

import java.util.Random;

public class RandomNumberGenerator {
    static final int UPPER_BOUND = 10;
    static final Random rand = new Random();

    public static int randomNumberGenerate() {
        return rand.nextInt(UPPER_BOUND);
    }
}
