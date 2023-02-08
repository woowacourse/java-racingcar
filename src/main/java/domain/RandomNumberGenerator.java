package domain;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int DIGIT_MAX = 10;

    public static int makeRandomDigit() {
        Random random = new Random();
        return random.nextInt(DIGIT_MAX);
    }
}
