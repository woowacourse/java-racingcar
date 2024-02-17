package model;

import java.util.List;

public class Racing {
    private static final int MIN_TRY_COUNT = 1;
    private static final int IMPOSSIBLE_TRY_COUNT = 0;
    
    private int tryCount;

    public Racing(int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야한다");
        }
    }

    public void doTry(Cars cars) {
        if (!canTry()) {
            return;
        }
        cars.tryForward();
        tryCount--;
    }

    public boolean canTry() {
        return tryCount > IMPOSSIBLE_TRY_COUNT;
    }

    public List<String> determineWinner(Cars cars) {
        int maxForwardCount = cars.calculateMaxForwardCount();
        return cars.findAllNameByForwardCount(maxForwardCount);
    }
}
