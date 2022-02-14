package racingcar.model;

import java.util.Objects;

public class Position {

    private int position = 0;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        this.position = position;
    }

    public static Position createPosition(int position) {
        return new Position(position);
    }

    public int getCurrentPosition() {
        return position;
    }

    public void increase() {
        this.position++;
    }

    public void changeIfSmallerThan(Position position) {
        if (this.isSmallerThan(position)) {
            this.position = position.getCurrentPosition();
        }
    }

    public boolean isSmallerThan(Position position) {
        return this.position < position.getCurrentPosition();
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
