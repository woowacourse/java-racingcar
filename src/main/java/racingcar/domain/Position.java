package racingcar.domain;

public class Position {
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

}
