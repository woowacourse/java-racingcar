package racingcargame.domain;

public class Position {
    private static final int STEP_SIZE = 1;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean isSamePosition(int comparedPosition) {
        return position == comparedPosition;
    }

    public void move() {
        position += STEP_SIZE;
    }
}
