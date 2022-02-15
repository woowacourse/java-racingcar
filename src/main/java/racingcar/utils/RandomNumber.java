package racingcar.utils;

public class RandomNumber {

    private static final int START_INCLUSIVE = 0;
    private static final int END_EXCLUSIVE = 9;

    public static int generate() {
        return (int)(Math.random() * (END_EXCLUSIVE - START_INCLUSIVE + 1)) + START_INCLUSIVE;
    }
}
