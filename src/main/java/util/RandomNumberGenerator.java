package util;

public class RandomNumberGenerator {

    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;

    public static int generate() {
        return (int) (Math.random() * (MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER));
    }

}
