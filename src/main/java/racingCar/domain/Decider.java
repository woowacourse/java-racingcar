package racingCar.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decider decider = (Decider) o;
        return value == decider.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
