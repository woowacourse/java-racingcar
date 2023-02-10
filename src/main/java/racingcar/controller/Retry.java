package racingcar.controller;

public class Retry {

    public static final Retry NO_RETRY = new Retry(0);
    private static final int ZERO = 0;

    private final int retryCount;

    public Retry(final int retryCount) {
        if (ZERO > retryCount) {
            throw new IllegalArgumentException("0 이상의 횟수만을 반복할 수 잇습니다.");
        }
        this.retryCount = retryCount;
    }

    public Retry retry() {
        return new Retry(retryCount - 1);
    }

    public boolean retryable() {
        return retryCount > 0;
    }
}
