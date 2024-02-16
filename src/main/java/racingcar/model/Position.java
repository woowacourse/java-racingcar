package racingcar.model;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(final int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
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
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
