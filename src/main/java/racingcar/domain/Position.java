package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    public static final int UP_POSITION = 1;

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position move() {
        return new Position(position + UP_POSITION);
    }

    public int get() {
        return position;
    }

    @Override
    public int compareTo(Position other) {
        return position - other.position;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Position position1 = (Position) other;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
