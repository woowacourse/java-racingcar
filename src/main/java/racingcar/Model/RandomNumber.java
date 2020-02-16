package racingcar.Model;

public class RandomNumber {
    private static final int CRITERIA_FOR_GO = 4;
    private int randomNumber;

    public RandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public boolean isMovable() {
        return this.randomNumber >= CRITERIA_FOR_GO;
    }
}
