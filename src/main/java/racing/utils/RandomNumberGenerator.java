package racing.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_MAX = 9;
    private static final int RANDOM_MIN = 0;

    @Override
    public int getNumber() {
        return ThreadLocalRandom.current()
                .ints(RANDOM_MIN, RANDOM_MAX)
                .findFirst()
                .orElse(RANDOM_MIN);
    }
}
