package util;

import java.security.SecureRandom;

public class RandomNumberGenerator {
    private static final int MAX_NUMBER = 9;
    private static final int BOUNDARY_NUMBER = MAX_NUMBER + 1;
    private static final SecureRandom secureRandom = new SecureRandom();

    private RandomNumberGenerator() {
    }

    public static int getRandomNumber() {
        return secureRandom.nextInt(BOUNDARY_NUMBER);
    }
}
