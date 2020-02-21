package racingcargame.domain;

public class NumberGenerator implements MovingConditionGenerator {
    private static final int NUMBER_RANGE = 10;
    public static final int MOVE_RANGE = 6;
    public static final int STOP_RANGE = 4;

    @Override
    public int createRandomNumber() {
        return (int)(Math.random() * NUMBER_RANGE);
    }

    @Override
    public int createMovingNumber() {
        return (int)(Math.random() * MOVE_RANGE) + STOP_RANGE;
    }

    @Override
    public int createStopNumber() {
        return (int)(Math.random() * STOP_RANGE);
    }
}
