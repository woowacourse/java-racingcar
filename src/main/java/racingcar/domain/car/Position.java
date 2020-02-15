package racingcar.domain.car;

public class Position implements Comparable<Position> {
    private static final String MARK = "-";

    private int location;

    public Position() {
        this.location = 0;
    }

    public Position(int location) {
        this.location = location;
    }

    public void moveForward() {
        location++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < location; i++) {
            result.append(MARK);
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Position) {
            return location == ((Position) o).location;
        }
        return false;
    }

    @Override
    public int compareTo(Position anotherPosition) {
        return Integer.compare(this.location, anotherPosition.location);
    }
}
