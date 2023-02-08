package racingcar.service;

public class CustomMoveStrategy extends MoveStrategy {
    private final int number;

    public CustomMoveStrategy(int number) {
        this.number = number;
    }

    @Override
    public boolean isMovable() {
        return number > STOP_BOUNDARY;
    }
}
