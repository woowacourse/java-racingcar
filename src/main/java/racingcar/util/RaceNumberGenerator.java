package racingcar.util;

import java.util.concurrent.ThreadLocalRandom;

public class RaceNumberGenerator implements NumberGenerator {

    private static final int LOWER_NUMBER = 0;

    private static final int UPPER_NUMBER = 9;

    @Override
    public int generate() {
        return LOWER_NUMBER + ThreadLocalRandom.current().nextInt(UPPER_NUMBER - LOWER_NUMBER + 1);
    }
}
