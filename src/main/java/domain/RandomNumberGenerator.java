package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random = new Random();
    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;

    @Override
    public int generate() {
        return random.nextInt((MAX_NUMBER_RANGE - MIN_NUMBER_RANGE) + 1) + MIN_NUMBER_RANGE;
    }
}
