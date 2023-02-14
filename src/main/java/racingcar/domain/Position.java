package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int START_POSITION = 0;

    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(final Position other) {
        return this.position - other.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position p = (Position) o;
        return Objects.equals(position, p.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
