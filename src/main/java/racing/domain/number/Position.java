package racing.domain.number;

import java.util.Objects;

public class Position implements Number, Comparable<Position> {
    private static final int ZERO = 0;

    private int value;

    private Position(final int value) {
        validatePosition(value);
        this.value = value;
    }

    public static Position of() {
        return new Position(ZERO);
    }

    public static Position of(final int value) {
        return new Position(value);
    }

    private void validatePosition(final int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("위치 값은 0 이상이어야 합니다.");
        }
    }

    public void add() {
        this.value++;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Position o) {
        if (this.value > o.value) {
            return 1;
        }
        return -1;
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
