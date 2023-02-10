package racingCar.domain;

public class Position implements Comparable<Position> {

    private static final int INIT_POSITION = 0;

    private int position;

    public Position() {
        this.position = INIT_POSITION;
    }

    public void increase() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position other) {
        return this.position - other.position;
    }
}
