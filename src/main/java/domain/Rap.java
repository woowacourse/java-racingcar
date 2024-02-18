package domain;

public class Rap {
    private static final int MIN_COUNT = 1;
    private int count;

    public Rap(final int count) {
        validateMinAttemptCount(count);
        this.count = count;
    }

    private static void validateMinAttemptCount(final int input) {
        if (input < MIN_COUNT) {
            throw new IllegalArgumentException(String.format("시도 횟수는 %d이상이어야 합니다.", MIN_COUNT));
        }
    }

    public void round() {
        count--;
    }

    public boolean isLeft() {
        return count > 0;
    }
}
