package racingCar.domain;

public class TryCount {

    private int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    protected void decrease() {
        --this.tryCount;
    }

    public boolean isZero() {
        return this.tryCount == 0;
    }
}

