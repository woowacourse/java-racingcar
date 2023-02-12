package racingcar.domain;

public class TryCount {
    private static final int MINIMUM_TRY_COUNT = 0;
    private final int tries;

    public TryCount(int tries) {
        validateTryCount(tries);
        this.tries = tries;
    }

    public int getTries() {
        return tries;
    }

    private void validateTryCount(int tries) {
        if (tries <= MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1이상의 숫자여야 합니다.");
        }
    }

}
