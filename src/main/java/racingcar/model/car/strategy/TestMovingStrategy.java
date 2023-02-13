package racingcar.model.car.strategy;

public class TestMovingStrategy implements MovingStrategy {
    private static final int MOVABLE_BOUNDARY_NUMBER = 4;

    private final int[] randomValue;
    private int index;

    public TestMovingStrategy(int[] randomValue) {
        this.randomValue = randomValue;
        this.index = -1;
    }

    @Override
    public boolean movable() {
        return randomValue[++index] >= MOVABLE_BOUNDARY_NUMBER;
    }
}
