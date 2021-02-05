package racingcar.domain;

public class GameRule {
    private static final int MOVE_PIVOT = 4;

    public boolean isMoveNumber(final int number) {
        return MOVE_PIVOT <= number;
    }
}
