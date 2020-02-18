package racingcar.domian.car;

public class Position {
    private static final int LIMIT_FOR_MOVE = 4;
    private int distance;

    public Position(int distance) {
        this.distance = distance;
    }

    public void move() {
        this.distance++;
    }

    public boolean isMovable(int number) {
        return number >= LIMIT_FOR_MOVE;
    }

    public int getDistance() {
        return this.distance;
    }

}
