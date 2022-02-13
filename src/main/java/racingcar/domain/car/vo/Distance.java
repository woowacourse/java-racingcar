package racingcar.domain.car.vo;

import java.util.Objects;

public class Distance {
    private int value;

    public Distance(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public void increaseBy(final int increasingAmount) {
        value += increasingAmount;
    }

    public boolean isSameOrHigherThan(final Distance another) {
        return this.value >= another.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
