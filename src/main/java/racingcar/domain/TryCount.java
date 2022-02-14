package racingcar.domain;

public class TryCount {

    private final int maxTryCount;
    private int currentTryCount;

    public TryCount(int maxTryCount) {
        this.maxTryCount = maxTryCount;
    }

    public void increment() {
        currentTryCount++;
    }

    public boolean isFinished() {
        return currentTryCount == maxTryCount;
    }
}
