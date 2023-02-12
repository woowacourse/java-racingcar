package domain;

public class TryTime {
    private int tryTime;

    public TryTime(final int tryTime) {
        validateTryTime(tryTime);
        this.tryTime = tryTime;
    }

    private static void validateTryTime(final int tryTime) {
        if (isNegative(tryTime)) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
    }

    private static boolean isNegative(final int tryTime) {
        return tryTime < 0;
    }

    public void decrease() {
        tryTime -= 1;
    }

    public boolean isRemain() {
        return tryTime > 0;
    }
}
