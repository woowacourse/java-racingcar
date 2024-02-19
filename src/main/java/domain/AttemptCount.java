package domain;

public class AttemptCount {
    private static final int MIN_ATTEMPT_COUNT = 1;
    private int count;

    public AttemptCount(int count) {
        validateMinAttemptCount(count);
        this.count = count;
    }

    private static void validateMinAttemptCount(int input) {
        if (input < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(String.format("시도 횟수는 %d 이상이어야 합니다.", MIN_ATTEMPT_COUNT));
        }
    }

    public void reduce() {
        count--;
    }

    public boolean isRemain() {
        return count > 0;
    }
}
