package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int UPPER_BOUND_EXCLUSIVE = 10;
    private static final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(UPPER_BOUND_EXCLUSIVE);
    }
}
