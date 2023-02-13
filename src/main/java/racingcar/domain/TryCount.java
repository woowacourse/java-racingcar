package racingcar.domain;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void reduce() {
        tryCount--;
    }

    public boolean isFinish() {
        return tryCount == 0;
    }
}
