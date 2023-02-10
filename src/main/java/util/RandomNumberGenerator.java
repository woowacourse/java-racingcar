package util;

public class RandomNumberGenerator {
    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;

    public Integer generateRandomNumber() {
        return (int) ((Math.random() * (MAX_NUMBER - MIN_NUMBER)) + MIN_NUMBER);
    }
}
