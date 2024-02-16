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
            throw new IllegalArgumentException(String.format("시도 횟수는 %d 이상이어야 합니다.", MIN_TRY_COUNT));
        }
    }

    public int getCount() {
        return count;
    }
}
