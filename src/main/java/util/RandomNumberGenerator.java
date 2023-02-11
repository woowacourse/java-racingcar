package util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final int MAX_RANDOM_NUMBER = 10;

    private final Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
