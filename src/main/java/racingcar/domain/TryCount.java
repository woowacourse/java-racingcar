package racingcar.domain;

public class TryCount {
    private static final int TRY_COUNT_MIN = 0;

    private final int tryCount;

    public TryCount(int tryCount) {
        validateCountInput(tryCount);
        this.tryCount = tryCount;
    }

    private void validateCountInput(int tryCount) {
        if (tryCount <= TRY_COUNT_MIN) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 0보다 큰 숫자여야 합니다.");
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
