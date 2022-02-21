package racingcar.utils.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random;
    private static final int RANDOM_BOUND = 10;
    private static final int FORWARD_NUMBER = 4;

    static {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    @Override
    public boolean canForward() {
        return random.nextInt(RANDOM_BOUND) >= FORWARD_NUMBER;
    }
}
