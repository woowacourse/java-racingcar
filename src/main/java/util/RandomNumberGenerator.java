package util;

public class RandomNumberGenerator {
    private static final int MAX_LIMIT = 10;

    private RandomNumberGenerator() {
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * MAX_LIMIT);
    }
}
