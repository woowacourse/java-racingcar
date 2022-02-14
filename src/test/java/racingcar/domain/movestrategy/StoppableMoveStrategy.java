package racingcar.domain.movestrategy;

public class StoppableMoveStrategy implements MoveStrategy {

    @Override
    public boolean canMove() {
        return false;
    }
}
