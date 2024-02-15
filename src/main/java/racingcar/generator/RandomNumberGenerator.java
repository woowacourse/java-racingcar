package racingcar.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAXIMUM_RANGE = 10;

    @Override
    public int generate() {
        return new Random().nextInt(MAXIMUM_RANGE);
    }
}
