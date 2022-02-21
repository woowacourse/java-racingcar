package racingcar.domain;

public class Count {
    private static final int MINIMUM_COUNT = 1;
    private static final int MAXIMUM_COUNT = 50;

    private int count;

    public Count(final int count) {
        checkCount(count);
        this.count = count;
    }

    private void checkCount(final int count) {
        checkMinimumCount(count);
        checkMaximumCount(count);
    }

    private void checkMaximumCount(final int count) {
        if (count > MAXIMUM_COUNT) {
            throw new IllegalArgumentException("입력횟수는 50 이하의 정수여야 합니다.");
        }
    }

    private void checkMinimumCount(final int count) {
        if (count < MINIMUM_COUNT) {
            throw new IllegalArgumentException("입력횟수는 1 이상의 정수여야 합니다.");
        }
    }

    public void decrease() {
        count--;
    }

    public boolean hasRemaining() {
        return count >= MINIMUM_COUNT;
    }
}
