package racingCar.domain;

public class TryCount {

    private static final int MIN_TRY_COUNT = 1;

    private final int tryCount;

    public TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도횟수는 1 이상이어야 합니다.");
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
