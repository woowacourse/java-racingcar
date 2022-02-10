package racingcar.util;

public class RandomUtil {

    private static final int CONDITION_VALUE = 4;

    public static boolean checkMoveOrWait() {
        return getRandomNumber() >= CONDITION_VALUE;
    }

    private static int getRandomNumber() {
        return (int) Math.floor(Math.random()*10);
    }
}
