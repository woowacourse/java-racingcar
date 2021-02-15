package racingcar.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    public static final Position ZERO = new Position(0);

    private final int value;

    private Position() {
        throw new IllegalStateException("Position은 위치값을 필요로 합니다.");
    }

    public Position(final int value) {
        validate(value);
        this.value = value;
    }

    public Position move() {
        return new Position(value + 1);
    }

    public boolean is(final Position position) {
        return this.value == position.value;
    }

    public int getValue() {
        return value;
    }

    private void validate(final int value) {
        validateMinimum(value);
    }

    private void validateMinimum(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 0부터 시작합니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Position position = (Position) obj;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position o) {
        return value - o.value;
    }
}
