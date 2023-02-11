package util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final int MAX_RANDOM_NUMBER = 9;

    @Override
    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
