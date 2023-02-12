package racingCar.domain;

public class TryCount {

    private int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    protected void decrease() {
        validateIsCountZero();
        --this.tryCount;
    }

    public boolean isZero() {
        return this.tryCount == 0;
    }

    private void validateIsCountZero() {
        if (isZero()) {
            throw new IllegalStateException("게임의 시도횟수를 모두 소진했습니다.");
        }
    }
}
