package domain;

public class GameMovingStrategyMock implements GameMovingStrategy {
    private static final int MOVING_NUMBER = 4;

    @Override
    public int getMovingNum() {
        return MOVING_NUMBER;
    }
}
