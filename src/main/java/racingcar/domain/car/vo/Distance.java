package racingcar.domain.car.vo;

import java.util.Objects;

public class Distance {
    private int distance;

    public Distance(final int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseBy(final int increasingAmount) {
        distance += increasingAmount;
    }

    public boolean isSameOrHigherThan(final Distance another) {
        return this.distance >= another.distance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return this.distance == distance.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
