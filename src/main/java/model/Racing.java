package model;

import java.util.List;

public class Racing {
    private int tryCount;

    public Racing(int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 1) {
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
       return tryCount > 0;
    }

    public List<String> determineWinner(Cars cars) {
        int maxForwardCount = cars.calculateMaxForwardCount();
        return cars.findAllNameByForwardCount(maxForwardCount);
    }
}
