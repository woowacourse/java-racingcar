package racingcar.util;

public class RandomUtils {

    private static final int MAX_NUM_EXCLUDE = 10;

    public static int generateNumber() {
        return (int) (Math.random() * MAX_NUM_EXCLUDE);
    }
}
