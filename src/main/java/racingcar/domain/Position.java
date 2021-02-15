package racingcar.domain;

public class Position {
    public static final Position ZERO = new Position(0);
    private static final int ONE = 1;

    private final int position;

    public Position(int value) {
        this.position = value;
    }

    public int getPosition() {
        return position;
    }

    public Position moveForward() {
        return new Position(position + ONE);
    }

    public boolean isSamePosition(int value) {
        return position == value;
    }
}
