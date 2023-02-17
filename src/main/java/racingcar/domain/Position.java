package racingcar.domain;

import java.util.Objects;

final class Position {
    public static final int MOVE = 1;
    private static final int INIT = 0;

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position init() {
        return new Position(INIT);
    }

    public Position move() {
        return new Position(position + MOVE);
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
        Position position = (Position) o;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
