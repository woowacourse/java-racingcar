package racingcar.domain;

import java.util.Objects;

public class Position {
    public static final int INIT_POSITION = 0;
    public static final String INVALID_POSITION_ERROR = "[ERROR] 포지션은 0이상의 정수여야 합니다.";

    private int position;

    public Position(int position) {
        validatePositiveNumber(position);
        this.position = position;
    }

    private void validatePositiveNumber(int position) {
        if (position < INIT_POSITION) {
            throw new IllegalArgumentException(INVALID_POSITION_ERROR);
        }
    }

    public void movePosition() {
        position++;
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