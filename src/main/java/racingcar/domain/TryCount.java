package racingcar.domain;

public class TryCount {

    private final int totalTryCount;
    private int currentTryCount;

    public TryCount(int totalTryCount) {
        this.totalTryCount = totalTryCount;
        this.currentTryCount = 0;
    }

    public void increaseCount() {
        currentTryCount++;
    }

    public boolean isFinished() {
        return currentTryCount == totalTryCount;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }

    public int getCurrentTryCount() {
        return currentTryCount;
    }
}
