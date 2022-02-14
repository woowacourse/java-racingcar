package racingcar.model;

public class Position {
    private static final String DISTANCE_MARK = "-";
    private static final int INITIAL_POSITION = 0;

    private int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public void move(int distance) {
        this.position += distance;
    }

    public int toInt() {
        return this.position;
    }

    public String toGraph() {
        return DISTANCE_MARK.repeat(Math.max(0, this.position));
    }

}
