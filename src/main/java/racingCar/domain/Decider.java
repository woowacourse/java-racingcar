package racingCar.domain;

public class Decider {
    public static final int MIN = 0;
    public static final int MAX = 9;

    private int value;

    public Decider(int value) {
        setValue(value);
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

    public void setValue(int input) {
        checkOutOfRange(input);
        this.value = input;
    }
}
