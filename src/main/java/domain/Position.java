package domain;

import java.util.Objects;

public class Position {
    private static final int INITIAL_POSITION = 0;

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public static Position create() {
        return new Position(INITIAL_POSITION);
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return getPosition() == position1.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
