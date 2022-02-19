package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int DEFAULT_POSITION_NUMBER = 0;
    private static final int FORWARD_NUMBER = 1;
    private int position;

    public Position() {
        this(DEFAULT_POSITION_NUMBER);
    }

    private Position(final int position) {
        this.position = position;
    }

    public Position moveForward() {
        return new Position(position + FORWARD_NUMBER);
    }

    public boolean isSamePosition(final int value) {
        return position == value;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position position) {
        return this.position - position.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
