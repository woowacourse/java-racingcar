package racingcar.domain.car;

import racingcar.exception.InvalidPositionException;

import java.util.Objects;

public class Position {

    private static final int START_POSITION = 0;

    private final int position;

    public Position(final int position) {
        if (position < START_POSITION) {
            throw new InvalidPositionException();
        }

        this.position = position;
    }

    public Position goForward() {
        return new Position(position + 1);
    }

    public int getValue() {
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
