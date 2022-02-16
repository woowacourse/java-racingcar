package racingcar.domain;

public class TryCount {

    private final int totalTryCount;
    private int currentTryCount = 0;

    public TryCount(int totalTryCount) {
        this.totalTryCount = totalTryCount;
    }

    public void increaseCount() {
        currentTryCount++;
    }

    public boolean isFinished() {
        return currentTryCount == totalTryCount;
    }

    public int getCurrentTryCount() {
        return currentTryCount;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }
}
