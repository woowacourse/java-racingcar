package racingcargame.model.car;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public void move(final int moveValue) {
        position += moveValue;
    }

    public int getPosition() {
        return position;
    }
}
