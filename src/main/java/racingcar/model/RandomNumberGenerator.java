package racingcar.model;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int MAXIMUM_RANDOM_RANGE = 10;

    public int generate() {
        return new Random().nextInt(MAXIMUM_RANDOM_RANGE);
    }
}
