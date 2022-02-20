package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;

    @Override
    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND - MIN_BOUND + 1) + MIN_BOUND;
    }
}
