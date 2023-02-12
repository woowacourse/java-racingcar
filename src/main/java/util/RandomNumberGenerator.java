package util;

import java.security.SecureRandom;

public class RandomNumberGenerator {
    private static final int MAX_NUMBER = 9;

    private RandomNumberGenerator() {
    }

    public static int getRandomNumber() {
        return new SecureRandom().nextInt(MAX_NUMBER+1);
    }
}
