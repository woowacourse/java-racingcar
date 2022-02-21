package racingcar.model;

public class BiggerNumberMoving implements Moving {

    private final static int MOVABLE_NUMBER = 4;

    @Override
    public boolean canMove(int number) {
        return number >= MOVABLE_NUMBER;
    }
}
