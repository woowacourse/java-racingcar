package util;

public class RandomNumberGenerator {
    private static final int MAX_NUMBER = 9;
    public static int getRandomNumber() {
        return (int) (Math.random() * MAX_NUMBER);
    }
}
