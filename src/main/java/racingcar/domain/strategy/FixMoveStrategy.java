package racingcar.domain.strategy;

public class FixMoveStrategy implements MoveStrategy {
    private static final int MOVING_DISTANCE = 1;
    private static final int STANDARD_VALUE = 4;

    private final int distance;

    public FixMoveStrategy(int distance) {
        this.distance = distance;
    }

    @Override
    public int move() {
        if (distance >= STANDARD_VALUE) {
            return MOVING_DISTANCE;
        }
        return 0;
    }
}
