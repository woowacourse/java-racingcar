package racingcar.util;

public class BoundedRandomNumberGenerator implements RandomNumberGenerator {
    private final int maxBound;
    private final int minBound;

    public BoundedRandomNumberGenerator(int maxBound, int minBound) {
        this.maxBound = maxBound;
        this.minBound = minBound;
    }

    @Override
    public int generate() {
        return random.nextInt(maxBound + 1 - minBound) + minBound;
    }
}
