package racingcar.domain;

import static racingcar.domain.Position.Validator.*;
import static racingcar.exception.ExceptionMessage.ILLEGAL_POSITION;

import java.util.Objects;

public class Position {
    private int value;

    public Position(int value) {
        validateNegativePosition(value);
        this.value = value;
    }

    public void forward() {
        value++;
    }

    public static class Validator {
        private Validator() {
        }

        public static void validateNegativePosition(int value) {
            if (value < 0) {
                throw new IllegalArgumentException(ILLEGAL_POSITION.getMessage());
            }
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
