package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int MIN_VALUE_TO_MOVE = 4;

    private int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position valueOf(final int value) {
        return new Position(value);
    }

    public int getMaxValue(Position position) {
        return Math.max(this.value, position.getValue());
    }

    public void move(int value) {
        if (value >= MIN_VALUE_TO_MOVE) {
            this.value++;
        }
    }

    public int getValue() {
        return this.value;
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
