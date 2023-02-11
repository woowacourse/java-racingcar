package racingcar.service;

public abstract class MoveStrategy {
    protected static final int STOP_BOUNDARY = 3;

    abstract boolean isMovable();
}
