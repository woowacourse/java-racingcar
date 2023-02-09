package racingcar.domain;

import java.util.Objects;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
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
