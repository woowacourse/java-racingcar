package util.number;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureRandomNumberGenerator {
    private static final int MAX_NUMBER = 9;

    public static int getRandomNumber() {
        int random = 0;
        try {
            random = SecureRandom.getInstanceStrong().nextInt(MAX_NUMBER);
        } catch (NoSuchAlgorithmException ignored) {
        }
        return random;
    }
}
