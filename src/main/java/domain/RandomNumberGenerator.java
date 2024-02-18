package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int RANDOM_RANGE = 10;

    @Override
    public int getRandom() {
        return new Random().nextInt(RANDOM_RANGE);
    }
}
