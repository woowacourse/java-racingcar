package racingcar.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random random = ThreadLocalRandom.current();

    @Override
    public int generateNumberInRange(final int startInclusive, final int endInclusive) {
        validateRange(startInclusive, endInclusive);
        return random.nextInt(startInclusive, endInclusive + 1);
    }

    private void validateRange(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive should be less than or equal to endInclusive");
        }
    }
}
