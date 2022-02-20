package racingcar.model.utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAX_RANDOM_VALUE = 10;
    private static final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}
