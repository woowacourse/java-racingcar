package model;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount) {
        verifyTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void verifyTryCount(int tryCount) {
        if (tryCount < 1 || tryCount > 120) {
            throw new IllegalArgumentException("시도 횟수는 1 이상 120 이하여야 합니다.");
        }
    }

    public void decreaseTryCount() {
        tryCount--;
    }

    public boolean hasTryCount() {
        return tryCount > 0;
    }
}
