package domain;

public class RandomNumberGenerator implements RandomGenerator {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    public int generate() {
        return (int) (Math.random() * RANDOM_NUMBER_UPPER_BOUND);
    }
}
