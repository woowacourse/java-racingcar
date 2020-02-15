package racingcar.domain;

public class MoveNumber {
    private int randomNumber;
    private static final int MOVE_FORWARD = 4;

    public MoveNumber(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException();
        }
        this.randomNumber = number;
    }

    boolean isMovable() {
        return this.randomNumber >= MOVE_FORWARD;
    }
}
