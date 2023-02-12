package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int DISTANCE_TO_MOVE = 1;
    private int position;

    public Position(int startPoint) {
        this.position = startPoint;
    }

    public void move() {
        position += DISTANCE_TO_MOVE;
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
        Position p = (Position) o;
        return Objects.equals(position, p.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
