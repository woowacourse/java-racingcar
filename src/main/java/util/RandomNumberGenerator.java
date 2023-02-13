package util;

public class RandomNumberGenerator implements NumberGenerator{
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public int generateNumber() {
        return (int) ((Math.random() * (MAX_NUMBER - MIN_NUMBER)) + MIN_NUMBER);
    }

}
