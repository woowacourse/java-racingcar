package racingcar.model.car;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int INCREASE_DISTANCE = 1;
    private static final int DEFAULT_POSITION = 0;

    private final int position;

    public Position() {
        this.position = DEFAULT_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public Position increase() {
        return new Position(position + INCREASE_DISTANCE);
    }

    public int toInt() {
        return position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Position position1 = (Position)object;
        return position == position1.position;
    }

    @Override
    public int compareTo(Position otherPosition) {
        return position - otherPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
