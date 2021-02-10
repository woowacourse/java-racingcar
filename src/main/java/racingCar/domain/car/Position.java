package racingCar.domain.car;

import java.util.Objects;

public class Position {

    public static final Position ZERO = new Position(0);
    private final int position;

    public Position(final int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0부터 시작한다.");
        }
        this.position = position;
    }

    public boolean isEqualTo(int max) {
        return this.position == max;
    }

    public Position goForward() {
        return new Position(position + 1);
    }

    public int getMaxValue(final int value) {
        return Integer.max(this.position, value);
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

    public int getPosition() {
        return position;
    }
}
