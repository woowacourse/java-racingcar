package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MAX_NUMBER_RANGE = 10;
    private static Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(MAX_NUMBER_RANGE);
    }
}
