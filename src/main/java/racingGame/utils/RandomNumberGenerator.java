package racingGame.utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int UPPER_BOUND = 10;

    @Override
    public int generateNumber() {
        return new Random().nextInt(UPPER_BOUND);
    }
}
