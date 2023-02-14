package racinggame.utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int UPPER_BOUND = 10;
    private static final Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(UPPER_BOUND);
    }
}
