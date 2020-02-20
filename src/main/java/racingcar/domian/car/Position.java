package racingcar.domian.car;

public class Position {
    private int distance;

    public Position(int distance) {
        this.distance = distance;
    }

    public void move() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }
}
