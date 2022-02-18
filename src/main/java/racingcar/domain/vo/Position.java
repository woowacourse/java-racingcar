package racingcar.domain.vo;

public class Position implements Comparable<Position> {

    private static final int INIT_POSITION = 0;

    private int position;

    public Position() {
        position = INIT_POSITION;
    }

    public void increase() {
        position++;
    }

    public int get() {
        return position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }

    @Override
    public int compareTo(Position position) {
        return this.position - position.position;
    }
}
