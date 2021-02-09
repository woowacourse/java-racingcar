package racingcar.domain;

public class Position {
    private static final Position ZERO = new Position(0);
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public static Position getZeroPosition(){
        return ZERO;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(int maxDistance) {
        return position == maxDistance;
    }

}
