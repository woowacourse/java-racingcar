package racing.domain;

import java.util.Objects;

public class Position {

    private static final int MOVEMENT = 1;

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position increase() {
        return new Position(this.position + MOVEMENT);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return getPosition() == position1.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
