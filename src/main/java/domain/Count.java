package domain;

import java.util.Objects;

public class Count {
    public static final int MIN_COUNT = 1;
    public static final int MAX_COUNT = 100;
    private final int count;

    public Count(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (isOutOfRange(count)) {
            throw new IllegalArgumentException(String.format("%d를 입력하셨습니다, 횟수는 1에서 100사이로 입력해주세요.", count));
        }
    }

    private static boolean isOutOfRange(int count) {
        return count < MIN_COUNT || count > MAX_COUNT;
    }

    public static Count from(int count) {
        return new Count(count);
    }

    public boolean isGreaterOrEqualThan(int currentCount) {
        return currentCount <= count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
