package domain.vo;

import java.util.Objects;

public class TryCount {

    private final int value;

    public TryCount(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryCount tryCount = (TryCount) o;
        return value == tryCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
