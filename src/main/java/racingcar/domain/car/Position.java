package racingcar.domain.car;

import java.util.Objects;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class Position implements Comparable<Position> {
    public static final int MIN_POSITION = 0;
    private int value;

    public Position(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int value) {
        if (value < MIN_POSITION) {
            throw new InvalidInputException(ErrorMessage.INVALID_POSITION);
        }
    }

    public void forward() {
        value++;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(final Position o) {
        return Integer.compare(this.value, o.value);
    }
}
