package racingcar.domain;

public interface CarMoveStrategy {
    int MOVE_BOUNDARY = 4;

    default boolean isMovable(int value) {
        return value >= MOVE_BOUNDARY;
    }
}
