package domain;

import exception.NegativeDistanceException;

import java.util.Objects;

public class Distance {
    public static final Distance ZERO = from(0);
    private final int distance;

    private Distance(int distance) {
        checkDistance(distance);

        this.distance = distance;
    }

    public static Distance from(int distance) {
        return new Distance(distance);
    }

    private void checkDistance(int distance) {
        if (distance < 0) {
            throw new NegativeDistanceException("distance 는 음수 일 수 없습니다.");
        }
    }

    public Distance increased() {
        return new Distance(distance + 1);
    }

    public int toInt() {
        return distance;
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
