package racingcar.domain.data;

import java.util.Objects;

public class Position {
    private final int value;

    Position(final int value) {
        this.value = value;
    }

    int value() {
        return this.value;
    }

    Position move() {
        return new Position(value + 1);
    }

    boolean isSameAs(final int maxPosition) {
        return this.value == maxPosition;
    }

    boolean isBigger(final int maxPosition) {
        return value > maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
