package racingcar.domain;

public class NoMoveStrategy implements MoveStrategy{
    @Override
    public boolean canMove() {
        return false;
    }
}
