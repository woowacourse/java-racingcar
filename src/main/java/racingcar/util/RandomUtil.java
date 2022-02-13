package racingcar.util;

public class RandomUtil {

    public static final int RANDOM_RANGE= 10;
    private static final int CONDITION_VALUE = 4;

    private RandomUtil() {
    }

    public static boolean checkMoveOrWait() {
        return getRandomNumber() >= CONDITION_VALUE;
    }

    private static int getRandomNumber() {
        return (int) Math.floor(Math.random()*RANDOM_RANGE);
    }
}
