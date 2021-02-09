package racingcar.domain;

public class Position {
    private final int position;

    public Position(int position) {
        this.position = position;
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
