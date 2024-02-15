package util;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int BOUND = 10;

    @Override
    public int generateNumber() {
        return (int) (Math.random() * BOUND);
    }
}
