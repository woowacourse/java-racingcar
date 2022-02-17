package racingcar.domain;

public class RandomMoveCondition implements MoveCondition {

    private static final int MINIMUM_MOVE = 4;
    private static final int RANDOM_RANGE = 10;

    private int makeRandomNumber() {
        return (int) (Math.random() * RANDOM_RANGE);
    }

    @Override
    public boolean isMovable() {
        return makeRandomNumber() >= MINIMUM_MOVE;
    }

}
