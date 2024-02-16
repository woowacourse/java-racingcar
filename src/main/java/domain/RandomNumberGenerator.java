package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static Random random = new Random();

    @Override
    public int generateRangeOf(int minRange, int maxRange) {
        return random.nextInt((maxRange - minRange) + 1) + minRange;
    }
}
