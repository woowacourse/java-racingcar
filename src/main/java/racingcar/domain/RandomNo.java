package racingcar.domain;

public class RandomNo {
    private int randomNumber;
    private static final int MOVE_FORWARD = 4;

    public RandomNo(int randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw new IllegalArgumentException();
        }
        this.randomNumber = randomNumber;
    }

    boolean isMovable() {
        return this.randomNumber >= MOVE_FORWARD;
    }
}
