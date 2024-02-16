package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int MINIMUM_TRY_COUNT = 1;

    private final int tryCount;
    private final Cars cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(int tryCount, Cars cars, RandomNumberGenerator randomNumberGenerator) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public TotalResult run() {
        List<RoundResult> gameResult = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            cars.makeCarMove(randomNumberGenerator);
            gameResult.add(cars.getRoundResult());
        }
        return new TotalResult(gameResult);
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
