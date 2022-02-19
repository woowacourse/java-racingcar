package racingcar.domain;

import static racingcar.message.ErrorMessages.*;

import java.util.Objects;

public class TryCount {
    private final int tryCount;

    public TryCount(String countString) {
        this.tryCount = convertStringToInt(countString);
        validatePositive(tryCount);
    }

    public boolean isNotSame(int tryCount) {
        return this.tryCount != tryCount;
    }

    private int convertStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_CNT_NOT_NUMBER);
        }
    }

    private void validatePositive(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(TRY_CNT_NOT_NATURAL_NUMBER);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TryCount tryCount1 = (TryCount) obj;
        return tryCount == tryCount1.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }

    @Override
    public String toString() {
        return "TryCount{" +
                "tryCount=" + tryCount +
                '}';
    }
}
