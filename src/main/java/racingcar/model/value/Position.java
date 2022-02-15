package racingcar.model.value;

import java.util.Objects;

public class Position {
    private static final int INITIAL_POSITION = 0;

    private int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public void move(int distance) {
        this.position += distance;
    }

    public int toInt() {
        return this.position;
    }

    public boolean isSameWith(int position) {
        return this.position == position;
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
