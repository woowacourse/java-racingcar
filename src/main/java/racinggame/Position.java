package racinggame;

import java.util.Objects;

public class Position {

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        // 검증 필요
        if (position < 0) {
            throw new RuntimeException();
        }

        return new Position(position);
    }

    public Position increase() {
        return Position.from(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
