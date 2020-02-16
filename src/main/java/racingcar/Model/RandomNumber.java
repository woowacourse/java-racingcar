package racingcar.Model;

public class RandomNumber {
    private static final int CRITERIA_FOR_GO = 4;
    public static final int RANDOM_UPPER_LIMIT = 9;
    public static final int RANDOM_LOWER_LIMIT = 1;
    private int randomNumber;

    public RandomNumber() {
        this.randomNumber = (int) (Math.random() * RANDOM_UPPER_LIMIT) + RANDOM_LOWER_LIMIT;
    }

    public boolean isMovable() {
        return this.randomNumber >= CRITERIA_FOR_GO;
    }
}
