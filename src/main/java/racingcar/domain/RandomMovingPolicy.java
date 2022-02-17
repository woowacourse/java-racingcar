package racingcar.domain;

public class RandomMovingPolicy implements MovingPolicy {
    private static final int MOVE_CONDITION = 4;
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    public boolean isMovable() {
        return pickNumber() >= MOVE_CONDITION;
    }

    private int pickNumber() {
        return (int)((Math.random() * ((END_INCLUSIVE + 1) - START_INCLUSIVE)) + START_INCLUSIVE);
    }
}
