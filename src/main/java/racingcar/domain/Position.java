package racingcar.domain;

import java.util.Objects;

public class Position {
    private final int position;

    public Position() {
        this(0);
    }

    private Position(final int position) {
        this.position = position;
    }

    public Position moveForward() {
       return new Position(position + 1);
    }

    public boolean isSameThan(final int winnerPosition) {
        return position == winnerPosition;
    }

    public int findBiggerPosition(final int winnerPosition) {
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
