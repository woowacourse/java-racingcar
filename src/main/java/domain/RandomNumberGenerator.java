package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private static final int MAX_RANDOM_UPPER_BOUND = 10;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_UPPER_BOUND);
    }
}
