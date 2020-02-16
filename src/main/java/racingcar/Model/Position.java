package racingcar.Model;

public class Position {
    private int position;
    private static final int INITIAL_POSITION = 0;

    public Position(int position) {
        this.position = position;
    }

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public void go() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
