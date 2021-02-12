package racingcar.model;

import java.util.Objects;

public class Distance {
    private static final int MIN_DISTANCE = 0;

    private int distance;

    public Distance(final int distance) {
        validateDistance(distance);
        this.distance = distance;
    }

    private void validateDistance(final int distance) {
        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException("[Error] 거리는 0 미만으로 초기화 할 수 없습니다.\n");
        }
    }

    public int getDistance() {
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
