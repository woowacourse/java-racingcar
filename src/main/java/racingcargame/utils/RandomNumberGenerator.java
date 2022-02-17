package racingcargame.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private final Random random = new Random();

    public int generateNumber(final int boundaryNumber) {
        return random.nextInt(boundaryNumber);
    }
}
