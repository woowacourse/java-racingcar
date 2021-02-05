package racingcar.constant;

public enum Digit {
    ZERO(0),
    TIMES_LIMITATION((int) 1e8),
    MINIMUM_CAR_NAME_LENGTH(1),
    MAXIMUM_CAR_NAME_LENGTH(5);

    private final int digit;

    Digit(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }
}
