package racingcar.domain;

public class Position {

    private static final int INIT_POSITION = 0;
    private int position;

    public Position() {
        this.position = INIT_POSITION;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
