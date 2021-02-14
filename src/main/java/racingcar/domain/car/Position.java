package racingcar.domain.car;

import java.util.Objects;

public class Position {

    private static final int DEFAULT_NUMBER = 0;
    private static final int MOVE_BOUND = 4;
    private static final Position DEFAULT_POSITION = new Position(DEFAULT_NUMBER);

    private final int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position valueOf(final int position) {
        if (position == DEFAULT_NUMBER) {
            return DEFAULT_POSITION;
        }
        return new Position(position);
    }

    public int getPosition() {
        return position;
    }

    public Position addPosition(final int value) {
        if (value < MOVE_BOUND) {
            return this;
        }
        return new Position(position + 1);
    }

    public boolean isEqualNumber(final int number) {
        return position == number;
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
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
