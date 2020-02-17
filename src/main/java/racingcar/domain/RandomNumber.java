package racingcar.domain;

public class RandomNumber implements NumberGenerator {
    private static final int RANDOM_VALUE_LIMIT = 10;
    private static final int FORWARD_NUMBER = 4;

    private int randomNumber;

    public RandomNumber() {
        this.randomNumber = (int) (Math.random() * RANDOM_VALUE_LIMIT);
    }

    @Override
    public boolean isMovable() {
        return randomNumber > FORWARD_NUMBER;
    }
}