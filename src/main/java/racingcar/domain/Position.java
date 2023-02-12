package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int INITIAL_DEFAULT_VALUE = 0;
    private int value = INITIAL_DEFAULT_VALUE;

    public void increasePosition() {
        this.value++;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.value, o.value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object o) {
        Position position = (Position) o;
        return this.value == position.value;
    }
}
