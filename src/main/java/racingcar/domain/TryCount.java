package racingcar.domain;

public class TryCount {

    private final int maxTryCount;
    private int currentTryCount = 0;

    public TryCount(int maxTryCount) {
        this.maxTryCount = maxTryCount;
    }

    public void increaseCount() {
        currentTryCount++;
    }

    public boolean isFinished() {
        return currentTryCount == maxTryCount;
    }

    public int getCurrentTryCount() {
        return currentTryCount;
    }
}
