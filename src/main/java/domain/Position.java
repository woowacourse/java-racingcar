package domain;

import java.util.Objects;

public class Position implements Comparable<Position>{
    private int position;

    public Position() {
        this.position = 0;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
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
        return getPosition() == position1.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }

    @Override
    public int compareTo(Position o) {
        return  o.position - this.position;
    }
}
