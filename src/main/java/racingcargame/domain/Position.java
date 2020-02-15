package racingcargame.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int STEP_SIZE = 1;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        position += STEP_SIZE;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.position, o.position);
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
}
