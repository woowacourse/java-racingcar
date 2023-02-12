package service;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random random = new Random();

    @Override
    public int generateNumber(final int maxNumber) {
        return random.nextInt(maxNumber);
    }
}
