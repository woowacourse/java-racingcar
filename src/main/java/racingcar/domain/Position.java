package racingcar.domain;

public class Position implements Comparable<Position> {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    public boolean isSame(Position position) {
        return this.position == position.position;
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.position, position.position);
    }
}
