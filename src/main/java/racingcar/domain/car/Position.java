package racingcar.domain.car;

import java.util.Objects;
import racingcar.exception.InvalidNumOfMoveException;

public class Position {

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        validationPosition(position);
        return new Position(position);
    }

    private static void validationPosition(int position) {
        if (position < 0) {
            throw new InvalidNumOfMoveException("시도횟수는 자연수이어야 합니다.");
        }
    }

    public Position plus(int position) {
        return Position.of(this.position + position);
    }

    public int getValue() {
        return position;
    }

    public boolean isOn(int max) {
        return max == position;
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
        return Objects.hashCode(position);
    }
}
