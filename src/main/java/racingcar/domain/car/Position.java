package racingcar.domain.car;

import java.util.Objects;

public class Position {

    private final int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.value = value;
    }

    public Position forward() {
        return new Position(value + 1);
    }

    public Position getMaxPosition(Position position) {
        return new Position(Integer.max(this.value, position.value));
    }

    public int getValue() {
        return value;
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
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
