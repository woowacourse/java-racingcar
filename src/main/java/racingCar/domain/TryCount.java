package racingCar.domain;

public class TryCount {

    private final int tryCount;

    public TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
