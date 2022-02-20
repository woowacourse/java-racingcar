package racingcar.domain.vo;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int INIT_POSITION = 0;

    private final int position;

    public Position() {
        position = INIT_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public Position increase() {
        return new Position(position + 1);
    }

    public int get() {
        return position;
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
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }

    @Override
    public int compareTo(Position position) {
        return this.position - position.position;
    }
}
