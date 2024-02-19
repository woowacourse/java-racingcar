package domain;

import java.util.Objects;

public class Count {
    public static final int MIN_COUNT = 1;
    public static final int MAX_COUNT = 100;
    private final int inputCount;
    private int currentCount;

    private Count(final int inputCount, final int currentCount) {
        validate(inputCount);
        this.inputCount = inputCount;
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
        return inputCount >= currentCount;
    }

    public Count increase() {
        return new Count(this.inputCount, currentCount + 1);
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
        return inputCount == count.inputCount && currentCount == count.currentCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputCount, currentCount);
    }
}
