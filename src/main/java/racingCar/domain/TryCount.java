package racingCar.domain;

public class TryCount {

    private final static int MIN_TRY_COUNT = 1;

    private int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도횟수는 1회 이상이어야 합니다.");
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
