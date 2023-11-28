package domain.core;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MINIMUM_BOUND = 1;
    private static final int MAXIMUM_BOUND = 9;

    public int generate() {
        return (int) (Math.random() * MAXIMUM_BOUND) + MINIMUM_BOUND;
    }
}
