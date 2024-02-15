package racingcar.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private int value;

    public Position(final int value) {
        this.value = value;
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
