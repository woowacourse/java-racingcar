package domain;

import java.util.Objects;

public class Count {
    public static final int MIN_COUNT = 1;
    public static final int MAX_COUNT = 100;
    private final int maxCount;
    private int currentCount;

    private Count(final int maxCount, int currentCount) {
        validate(maxCount);
        this.maxCount = maxCount;
        this.currentCount = currentCount;
    }

    public static Count from(int maxCount) {
        return new Count(maxCount, 1);
    }

    private void validate(int count) {
        if (!isValidCount(count)) {
            throw new IllegalArgumentException("횟수는 1에서 100사이로 입력해주세요.");
        }
    }

    private static boolean isValidCount(int count) {
        return count >= MIN_COUNT && count <= MAX_COUNT;
    }

    public boolean isExits() {
        return maxCount >= currentCount;
    }

    public void increase() {
        currentCount++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Count count = (Count) o;
        return maxCount == count.maxCount && currentCount == count.currentCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxCount, currentCount);
    }
}
