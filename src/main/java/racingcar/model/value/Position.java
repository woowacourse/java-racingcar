package racingcar.model.value;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int INITIAL_POSITION = 0;

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position create() {
        return new Position(INITIAL_POSITION);
    }

    public Position move(int distance) {
        return new Position(position + distance);
    }

    public int toInt() {
        return this.position;
    }

    @Override
    public int compareTo(Position compareTarget) {
        return Integer.compare(position, compareTarget.position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position1 = (Position) obj;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
