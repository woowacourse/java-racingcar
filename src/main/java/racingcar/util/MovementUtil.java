package racingcar.util;

public class MovementUtil {

    private MovementUtil() {
    }

    private static final int MOVE_CONDITION = 4;

    public static boolean isMoveForward(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }
}
