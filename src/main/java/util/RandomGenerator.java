package util;

import java.util.Random;

public class RandomGenerator {

    private static final int DIGIT_BOUND = 10;
    private static final Random random = new Random();

    public static int getDigit() {
        return random.nextInt(DIGIT_BOUND);
    }
}
