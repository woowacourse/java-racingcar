package racingcar.domain;

public class RandomBasedStrategy implements MoveStrategy {

    private static final int MINIMUM_MOVABLE_NUMBER = 4;
    public static final int MAXIMUM_NUMBER_OF_RANGE = 9;

    @Override
    public boolean isMovable() {
        return getRandom() >= MINIMUM_MOVABLE_NUMBER;
    }

    private static int getRandom() {
        return (int) ((Math.random() * 10000) % MAXIMUM_NUMBER_OF_RANGE);
    }
}
