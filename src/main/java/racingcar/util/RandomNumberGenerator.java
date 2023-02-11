package racingcar.util;

import java.security.SecureRandom;

public class RandomNumberGenerator {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    public static int pickNumberInRange(int min, int max) {
        return SECURE_RANDOM.nextInt(max - 2) + min;
    }
}
