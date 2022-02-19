package racingcar.utils.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random;
    private static final int FORWARD_NUMBER = 4;
    private static final int RANDOM_BOUND = 10;

    static {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    @Override
    public int generate() {
        return random.nextInt(RANDOM_BOUND);
    }
}
