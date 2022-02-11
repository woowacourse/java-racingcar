package racingcar.util;

import static racingcar.constant.ConditionInfo.CONDITION_FOR_MOVE;

public class RandomUtil {

    public static boolean checkMoveOrWait() {
        return getRandomNumber() >= CONDITION_FOR_MOVE;
    }

    private static int getRandomNumber() {
        return (int) Math.floor(Math.random()*10);
    }
}
