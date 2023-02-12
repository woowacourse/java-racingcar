package racingcar.domain;

import java.util.Objects;

import static racingcar.exception.ExceptionMessage.ILLEGAL_POSITION;

public class Position {
    private int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(value < 0) {
            throw new IllegalStateException(ILLEGAL_POSITION.getMessage());
        }
    }

    public void forward() {
        value++;
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
