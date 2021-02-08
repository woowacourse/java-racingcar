package racingcar.domain;

public class GameRule {
    private static final int MOVE_PIVOT = 4;

    private GameRule() {
    }

    public static boolean isMoveNumber(final int number) {
        return MOVE_PIVOT <= number;
    }
}
