package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private final int value;

    private static final Position positionOne = new Position(1);

    private Position(int position) {
        this.value = position;
    }

    public static Position valueOf(int value) {
        if (value < 0) {
            throw new RuntimeException("Position의 값은 0 이상의 자연수만 가능함");
        }
        if (value == 1) {
            return positionOne;
        }
        return new Position(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return this.value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Position plusOne() {
        return new Position(this.value + 1);
    }

    public int toInt() {
        return value;
    }

    @Override
    public int compareTo(Position position) {
        if (position.value < this.value) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
