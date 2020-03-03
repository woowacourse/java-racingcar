package racing.model;

import java.util.Objects;

public class Position {
    private static final int STEP = 1;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void add() {
        position += STEP;
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
        Position targetPosition = (Position) o;
        return position == targetPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
