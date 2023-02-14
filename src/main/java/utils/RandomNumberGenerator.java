package utils;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    @Override
    public int generateNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_UPPER_BOUND);
    }
}
