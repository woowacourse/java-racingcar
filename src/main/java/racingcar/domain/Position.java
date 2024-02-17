package racingcar.domain;

public class Position {
    private static final int INITIAL_POSITION = 0;

    private int position;

    public Position() {
        this.position = INITIAL_POSITION;
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
}
