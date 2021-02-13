package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable {

    private final int value;

    private static final Position positionOne = new Position(1);

    private Position(int position) {
        this.value = position;
    }

    public static Position valueOf(int value) {
        if (value == 1) {
            return positionOne;
        }
        return new Position(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Position plusOne() {
        return new Position(this.value + 1);
    }

    public int toInt() {
        return value;
    }

    @Override
    public int compareTo(Object obj) {
        Position position = (Position) obj;
        if (position.value < this.value) {
            return 1;
        }
        return 0;
    }
}
