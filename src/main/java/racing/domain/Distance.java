package racing.domain;

import java.util.Objects;

public class Distance {

    private static final int INITIAL_DISTANCE = 1;

    private int distance;

    public Distance() {
        this.distance = INITIAL_DISTANCE;
    }

    public void increase() {
        this.distance++;
    }

    public boolean isEqual(int distance) {
        return this.distance == distance;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
