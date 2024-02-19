package racingcar.domain.car.move.generator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 9;

    @Override
    public int generate() {
        Random random = ThreadLocalRandom.current();
        return RANDOM_LOWER_INCLUSIVE + random.nextInt(RANDOM_UPPER_INCLUSIVE - RANDOM_LOWER_INCLUSIVE + 1);
    }
}
