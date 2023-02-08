package racingcar;

public class RandomBasedStrategy implements MoveStrategy {
    @Override
    public boolean isMovable() {
        return getRandom() >= 4;
    }

    private static int getRandom() {
        return (int) Math.random();
    }
}
