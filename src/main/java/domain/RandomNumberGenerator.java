package domain;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    public static int generate() {
        return (int) (Math.random() * RANDOM_NUMBER_UPPER_BOUND);
    }
}
