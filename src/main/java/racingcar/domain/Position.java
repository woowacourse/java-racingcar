package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int INITIAL_VALUE = 0;

    private int value = INITIAL_VALUE;

    public void increase() {
        value++;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return getValue() == position.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
