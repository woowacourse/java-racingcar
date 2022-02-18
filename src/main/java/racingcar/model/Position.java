package racingcar.model;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int START_POSITION_VALUE = 0;

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position createStartPosition() {
        return new Position(START_POSITION_VALUE);
    }

    public void increase() {
        this.position++;
    }

    public int getCurrentPosition() {
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
    public int compareTo(Position o) {
        return Integer.compare(position, o.getCurrentPosition());
    }
}
