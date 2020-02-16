package racingcar.domain;

public class MoveNumber {
    private static final int MINIMUM_MOVE_NUMBER = 0;
    private static final int MAXIMUM_MOVE_NUMBER = 9;
    private int randomNumber;
    private static final int MOVE_FORWARD = 4;

    public MoveNumber(int number) {
        if (number < MINIMUM_MOVE_NUMBER || number > MAXIMUM_MOVE_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.randomNumber = number;
    }

    boolean isMovable() {
        return this.randomNumber >= MOVE_FORWARD;
    }
}
