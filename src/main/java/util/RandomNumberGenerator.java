package util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_NUMBER_STANDARD = 10;

    @Override
    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_STANDARD);
    }
}
