package racingcar.domain.movestrategy;

public class StoppableMovingStrategy implements MovingStrategy {

    @Override
    public boolean canMove() {
        return false;
    }
}
