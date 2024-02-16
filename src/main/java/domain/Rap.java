package domain;

public class Rap {
    private static final int MIN_COUNT = 1;
    private int count;

    private Rap(int count) {
        this.count = count;
    }

    public static Rap from(int count) {
        validateMinAttemptCount(count);
        return new Rap(count);
    }

    private static void validateMinAttemptCount(int input) {
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
