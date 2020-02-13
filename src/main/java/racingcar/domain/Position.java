package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int MIN_POSITION = 1;
    private static final int MAX_POSITION = 101;
    public static final String CAR_OUT_OF_RANGE_MESSAGE = "car의 position이 범위를 벗어났습니다.";

    private int position;

    public Position() {
        this(1);
    }

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(final int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException(CAR_OUT_OF_RANGE_MESSAGE);
        }
    }

    public void moveForward() {
        validatePosition(position + 1);
        position++;
    }

    public boolean isPositionOf(final int position) {
        return this.position == position;
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
