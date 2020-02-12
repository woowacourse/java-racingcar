package racingcargame.domain;

public class CarPosition {
    public static final int DEFAULT_POSITION = 0;
    public static final int MOVE_UNIT = 1;

    private int position;

    public CarPosition() {
        this.position = DEFAULT_POSITION;
    }

    public void increase() {
        position += MOVE_UNIT;
    }

    public int getPosition() {
        return position;
    }
}
