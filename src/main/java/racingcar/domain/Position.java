package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int UNIT_OF_MOVE = 1;

    private int position;

    public Position() {
        this(0);
    }

    private Position(int position) {
        this.position = position;
    }

    public void moveForward() {
        position += UNIT_OF_MOVE;
    }

    public boolean isSameThan(int winnerPosition) {
        return position == winnerPosition;
    }

    public int findBiggerPosition(int winnerPosition) {
        return Integer.max(winnerPosition, position);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
