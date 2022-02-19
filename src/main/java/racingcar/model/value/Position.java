package racingcar.model.value;

import java.util.Objects;

public class Position implements Comparable {
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

    public boolean isSameWith(int position) {
        return this.position == position;
    }

    @Override
    public int compareTo(Object obj) {
        Position position1 = (Position) obj;
        return Integer.compare(position, position1.position);
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
