package racingcar.util;

public class Utils {
    private static final int MAX_RANDOM_NUMBER = 10;

    public static int randomNumberGenerator() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER);
    }
}
