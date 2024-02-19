package racing.domain;

public class TryCount {

    private static final String INVALID_ATTEMPT_COUNT = "시도가 0 이하입니다.";

    private int tryCount;

    public TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT);
        }
    }

    public boolean isRemain() {
        return tryCount > 0;
    }

    public void consume() {
        tryCount--;
    }
}
