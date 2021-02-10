package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final String NEGATIVE_NUMBER_ERROR = "위치값은 음수가 될 수 없습니다.";
    private int position;

    public Position(int position) {
        validateNumber(position);
        this.position = position;
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
        }
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int getMaxValue(Position position) {
        return Math.max(this.position, position.position);
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
