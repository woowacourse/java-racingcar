package racingcar.constant;

public enum Digit {
    ZERO(0),
    TIMES_LIMITATION((int) 1e8);

    private final int digit;

    Digit(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }
}
