package utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random random = new Random();

    @Override
    public int generate() {
        final int RANDOM_NUMBER_RANGE = 10;
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
