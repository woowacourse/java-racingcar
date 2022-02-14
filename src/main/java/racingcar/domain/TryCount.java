package racingcar.domain;

import racingcar.domain.exception.RacingGameIsFinishedException;

public class TryCount {

    private final int maxTryCount;
    private int currentTryCount;

    public TryCount(int maxTryCount) {
        this.maxTryCount = maxTryCount;
        this.currentTryCount = 0;
    }

    public void increment() {
        if (isReachedMaxCount()) {
            throw new RacingGameIsFinishedException();
        }
        currentTryCount++;
    }

    public boolean isReachedMaxCount() {
        return currentTryCount == maxTryCount;
    }
}
