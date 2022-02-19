package racingcar.domain.movestrategy;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int PROGRESS_CONDITION_VALUE = 4;
    private static final int RANDOM_RANGE = 10;

    @Override
    public boolean isMovable() {
        int randomNumber = getRandomNumber();

        return randomNumber >= PROGRESS_CONDITION_VALUE;
    }

    private static int getRandomNumber() {
        return (int) Math.floor(Math.random() * RANDOM_RANGE);
    }
}
