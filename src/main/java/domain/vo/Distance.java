package domain.vo;

import java.util.Objects;

public class Distance {

    private final int value;

    public Distance(int value) {
        this.value = value;
    }

    public static Distance initial() {
        return new Distance(0);
    }

    public Distance plus(int value) {
        return new Distance(this.value + value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
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
