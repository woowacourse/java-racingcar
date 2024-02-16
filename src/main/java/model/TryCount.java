package model;

public class TryCount {
    private static final int MIN_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 120;

    private int tryCount;

    public TryCount(int tryCount) {
        validateRange(tryCount);
        this.tryCount = tryCount;
    }

    private void validateRange(int tryCount) {
        if (tryCount < MIN_TRY_COUNT || tryCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException(
                    String.format("시도 횟수는 %d 이상 %d 이하여야 합니다.", MIN_TRY_COUNT, MAX_TRY_COUNT));
        }
    }

    public void decreaseTryCount() {
        if (tryCount == 0) {
            throw new IllegalStateException("시도 횟수가 모두 소진되었습니다.");
        }
        tryCount--;
    }

    public boolean hasTryCount() {
        return tryCount > 0;
    }
}
