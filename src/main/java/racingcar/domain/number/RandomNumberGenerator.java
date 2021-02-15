package racingcar.domain.number;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    private static final Random random = new Random();

    @Override
    public int generate() {
        return MINIMUM_NUMBER + random.nextInt(MAXIMUM_NUMBER - MINIMUM_NUMBER + 1);
    }
}

