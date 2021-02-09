package racingcar.domain;

import java.util.Objects;

public class Position {
    public static final Position ZERO = new Position(0);

    private static final int ONE = 1;

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position nextPosition() {
        return new Position(this.position + ONE);
    }

    public int index(){
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position that = (Position) obj;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
