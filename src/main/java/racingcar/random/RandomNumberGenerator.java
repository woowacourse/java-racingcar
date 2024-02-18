package racingcar.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random random = ThreadLocalRandom.current();
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    @Override
    public int generateNumberInRange() {
        return random.nextInt(MIN_RANGE, MAX_RANGE + 1);
    }
}
