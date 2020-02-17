package racingCar.domain;

public class Decider {
    public static final int MIN = 0;
    public static final int MAX = 9;

    private final int value;

    public Decider(final int value) {
        checkOutOfRange(value);
        this.value = value;
    }

    private void checkOutOfRange(int input) {
        if (input < MIN || input > MAX) {
            throw new RuntimeException();
        }
    }

    public boolean isBiggerThan(int input) {
        return value > input;
    }

    public int getValue() {
        return value;
    }

}
