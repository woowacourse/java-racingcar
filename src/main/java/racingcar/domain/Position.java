package racingcar.domain;

import java.util.Objects;

public class Position {

    public static final Position ZERO = new Position(0);
    private final int value;

    public Position(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[Error] 거리는 0보다 커야합니다.");
        }
        this.value = value;
    }

    public Position move() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    public boolean isSamePosition(final int value) {
        return (this.value == value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
