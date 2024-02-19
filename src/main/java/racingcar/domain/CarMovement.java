package racingcar.domain;

public class CarMovement implements CarMoveStrategy {
    @Override
    public boolean isMovable(int value) {
        return CarMoveStrategy.super.isMovable(value);
    }
}
