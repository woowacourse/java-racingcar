package racinggame.race.car;

import java.util.Objects;

public class Distance {
    private static final int STARTING_POSITION = 1;
    private static final int MOVE_DISTANCE = 1;

    private final int distance;

    private Distance(int distance) {
        this.distance = distance;
    }

    public static Distance startingPosition() {
        return new Distance(STARTING_POSITION);
    }

    public int getDistance() {
        return distance;
    }

    public Distance move() {
        return new Distance(distance + MOVE_DISTANCE);
    }

    public boolean isEqual(int distance) {
        return this.distance == distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
