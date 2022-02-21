package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();

    private final int lowerBound;
    private final int upperBound;

    private RandomNumberGenerator(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public static RandomNumberGenerator fromBounds(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            return new RandomNumberGenerator(upperBound, lowerBound);
        }
        return new RandomNumberGenerator(lowerBound, upperBound);
    }

    @Override
    public int generate() {
        if (lowerBound == upperBound) {
            return lowerBound;
        }
        return lowerBound + random.nextInt(upperBound - lowerBound);
    }
}