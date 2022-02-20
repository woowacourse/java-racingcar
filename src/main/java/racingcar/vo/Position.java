package racingcar.vo;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int INIT_POSITION = 0;
    private static final String POSITION_BAR = "-";

    private int position;

    public Position() {
        this.position = INIT_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_BAR);
        }
        return builder.toString();
    }

    @Override
    public int compareTo(Position position) {
        return this.position - position.position;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Position position = (Position) object;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }
}
