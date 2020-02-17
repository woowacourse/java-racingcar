package racingcargame.domain;

public class Position {
    public static final int DEFAULT_POSITION = 0;
    public static final int MOVE_UNIT = 1;

    private int position;

    public Position() {
        this.position = DEFAULT_POSITION;
    }

    public Position(int pos) {
        this.position = pos;
    }

    public int increase() {
        this.position += MOVE_UNIT;
        return position;
    }

    public int getPosition() {
        return position;
    }

}
