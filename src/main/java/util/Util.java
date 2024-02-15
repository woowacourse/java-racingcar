package util;

public class Util {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public static int generateRandomNumber() {
        return (int) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER);
    }
}
