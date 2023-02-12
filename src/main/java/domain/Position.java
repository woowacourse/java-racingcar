package domain;

import java.util.Objects;

public class Position {

    public static final int DEFAULT_POSITION_VALUE = 0;

    private int position = DEFAULT_POSITION_VALUE;

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public int compareTo(Position other) {
        return this.position - other.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position other = (Position) o;
        return position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
