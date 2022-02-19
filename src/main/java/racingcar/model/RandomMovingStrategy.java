package racingcar.model;

public class RandomMovingStrategy implements MovingCarStrategy {
    private static final int MOVING_CONDITION_NUMBER = 4;

    @Override
    public boolean canMove() {
        return getRandomNumber() >= MOVING_CONDITION_NUMBER;
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
