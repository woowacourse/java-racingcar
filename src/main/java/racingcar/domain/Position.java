package racingcar.domain;

public class Position implements Comparable<Position> {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        this.position++;
    }

    public boolean isMatchPosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position other) {
        return position - other.position;
    }
}
