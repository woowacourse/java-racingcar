package racingcar.domain.util;

public class MovementUtil {

    private static final int MOVE_CONDITION = 4;

    public static boolean isMoveForward(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    public static int getMoveCondition() {
        return MOVE_CONDITION;
    }
}
