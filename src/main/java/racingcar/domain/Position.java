package racingcar.domain;

import java.util.Objects;

public class Position {
    public static final Position ZERO = new Position(0);

    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public Position move() {
        return new Position(value + 1);
    }

    public int getPosition() {
        return value;
    }

    public int getMaxPosition(int position) {
        return Integer.max(value, position);
    }

    public boolean isSamePosition(int position) {
        return value == position;
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
