package racingcar.model;

import java.util.Objects;

public class TryCount {

    private static final int MINIMUM_TRY_COUNT = 1;

    private final int count;

    public TryCount(int count) {
        validateTryCount(count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            String message = "TryCount가 " + MINIMUM_TRY_COUNT + "보다 작은 숫자가 입력되었습니다. 입력값 : " + tryCount;
            throw new IllegalArgumentException(message);
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
        TryCount tryCount = (TryCount) obj;
        return this.count == tryCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }

    @Override
    public String toString() {
        return "TryCount{" +
                "count=" + count +
                "}";
    }
}
