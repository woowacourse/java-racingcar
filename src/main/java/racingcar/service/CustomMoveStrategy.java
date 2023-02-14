package racingcar.service;

public class CustomMoveStrategy extends MoveStrategy {
    private static final int STOP_BOUNDARY = 3;
    private final int number;

    public CustomMoveStrategy(int number) {
        this.number = number;
    }

    @Override
    public boolean isMovable() {
        return number > STOP_BOUNDARY;
    }
}
