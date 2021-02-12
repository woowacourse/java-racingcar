package racingcar.domain.car.strategy;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVABLE_VALUE = 4;

    @Override
    public boolean isMovable(int moveValue) {
        return moveValue >= MOVABLE_VALUE;
    }
}
