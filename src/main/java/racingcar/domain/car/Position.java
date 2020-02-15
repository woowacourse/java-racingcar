package racingcar.domain.car;

public class Position implements Comparable<Position> {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void moveForward() {
        position++;
    }

    @Override
    public String toString() {
        return String.valueOf(position);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Position) {
            return position == ((Position) o).position;
        }
        return false;
    }

    @Override
    public int compareTo(Position anotherPosition) {
        return Integer.compare(this.position, anotherPosition.position);
    }
}
