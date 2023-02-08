package racingcar.domain;

public class Position {

    private static final int INIT_VALUE = 0;
    private static final int BOUNDARY_NUMBER = 4;
    private static final int MOVE_INTERVAL = 1;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private final int value;

    public Position(final int value) {
        this.value = value;
    }

    public static Position init() {
        return new Position(INIT_VALUE);
    }

    public int getValue() {
        return this.value;
    }

    public Position move(final int randomNumber) {
        validateRange(randomNumber);

        return nextPosition(randomNumber);
    }

    private Position nextPosition(int randomNumber) {
        if (randomNumber >= BOUNDARY_NUMBER) {
            return new Position(this.value + MOVE_INTERVAL);
        }
        return this;
    }

    private void validateRange(final int randomNumber) {
        if (randomNumber < MIN_RANGE || randomNumber > MAX_RANGE) {
            throw new IllegalArgumentException();
        }
    }
}