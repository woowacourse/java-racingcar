package racingcar.util;

import java.util.Random;

public class BoundedRandomNumberGenerator implements RandomNumberGenerator {
    private int maxBound;
    private int minBound;
    private Random random;

    public BoundedRandomNumberGenerator(int maxBound, int minBound) {
        this.random = new Random();
        this.maxBound = maxBound;
        this.minBound = minBound;
    }

    @Override
    public int generate() {
        return random.nextInt(maxBound + 1 - minBound) + minBound;
    }
}
