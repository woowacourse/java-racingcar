package racingcar.domain;


import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int ZERO = 0;
    private static final int STEP = 1;
    public static final Position START = new Position(ZERO);
    public static final String MINIMUM_VALUE_ERROR_MESSAGE
            = "[ERROR] Position 값은 음수가 될 수 없습니다.";

    private final int value;

    public Position(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException(MINIMUM_VALUE_ERROR_MESSAGE);
        }
    }

    public Position move() {
        return new Position(value + STEP);
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
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

    @Override
    public int compareTo(Position o) {
        return Integer.compare(value, o.value);
    }
}
