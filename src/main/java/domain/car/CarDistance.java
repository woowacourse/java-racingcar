package domain.car;

import java.util.Objects;

public record CarDistance(int distance) {
    private static final CarDistance INITIAL_DISTANCE = new CarDistance(0);

    public CarDistance getNextDistance() {
        return new CarDistance(this.distance() + 1);
    }

    public static CarDistance getInitialDistance() {
        return INITIAL_DISTANCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDistance that = (CarDistance) o;
        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
