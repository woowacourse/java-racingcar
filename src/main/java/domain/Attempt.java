package domain;

public class Attempt {
    private static final int MIN_TRY_COUNT = 1;
    private final int count;

    private Attempt(int count) {
        this.count = count;
    }

    public static Attempt from(int count) {
        validateMinTryCount(count);
        return new Attempt(count);
    }

    private static void validateMinTryCount(int input) {
        if (input < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
