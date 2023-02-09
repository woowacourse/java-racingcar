package racingCar.domain;

public class Position implements Comparable<Position> {
    private int position = 0;

    public void increase() {
        ++this.position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position other) {
        return this.position - other.position;
    }
}
