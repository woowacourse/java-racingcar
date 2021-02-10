package racingcar.domain.car;

public class Position {
    public static final Position ZERO = new Position(0);

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public Position move() {
        return new Position(this.position + 1);
    }
}
