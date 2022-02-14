package racingcar.domain;

public class TryCount {
    private final int maxTryCount;
    private int currentTryCount;

    public TryCount(int maxTryCount) {
        this.maxTryCount = maxTryCount;
        this.currentTryCount = 0;
    }

    public void increment() {
        currentTryCount++;
    }

    public boolean isFinished() {
        return currentTryCount == maxTryCount;
    }
}
