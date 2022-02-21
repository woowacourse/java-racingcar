package racingcar.domain;

public class Distance {
    private static final int INITIAL_DISTANCE = 0;

    private int distance;

    public Distance() {
        this.distance = INITIAL_DISTANCE;
    }

    public int getDistance() {
        return distance;
    }

    public void plus() {
        distance++;
    }

    public boolean isSameWith(int distance) {
        return this.distance == distance;
    }

    public boolean isBigger(Distance otherCar) {
        return this.distance > otherCar.distance;
    }
}
