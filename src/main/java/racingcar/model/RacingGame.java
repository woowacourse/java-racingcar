package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int MINIMUM_TRY_COUNT = 1;

    private final int tryCount;
    private final Cars cars;

    public RacingGame(int tryCount, Cars cars) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public List<RoundResult> run() {
        List<RoundResult> gameResult = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            gameResult.add(cars.makeCarsMove());
        }
        return gameResult;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
