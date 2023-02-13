package util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_NUMBER_STANDARD = 10;
    private static Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(RANDOM_NUMBER_STANDARD);
    }
}
