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

    @Override
    public int compareTo(Position other) {
        return position - other.position;
    }

    public int getInt() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position1 = (Position)o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
