package utils;

public class RandomUtil {
    private static final int RANDOM_NUMBER_RANGE = 10;

    public static int randomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_RANGE);
    }
}
