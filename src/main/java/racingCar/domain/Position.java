package racingCar.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        position++;
    }

    public int get() {
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
        Position position1 = (Position) obj;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}