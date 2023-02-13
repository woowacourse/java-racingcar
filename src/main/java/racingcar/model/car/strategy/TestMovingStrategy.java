package racingcar.model.car.strategy;

public class TestMovingStrategy implements MovingStrategy {
    private final int[] randomValue;
    private int index = -1;

    public TestMovingStrategy(int[] randomValue) {
        this.randomValue = randomValue;
    }

    @Override
    public boolean movable() {
        index++;

        if (randomValue[index] >= 4) {
            return true;
        }
        return false;
    }
}
