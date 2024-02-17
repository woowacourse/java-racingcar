package racingcar.model;

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
        TotalResult totalResult = new TotalResult();
        for (int i = 0; i < tryCount; i++) {
            cars.makeCarMove(randomNumberGenerator);
            totalResult.addResult(cars.getRoundResult());
        }
        return totalResult;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            String message = "TryCount가 " + MINIMUM_TRY_COUNT + "보다 작은 숫자가 입력되었습니다. 입력값 : " + tryCount;
            throw new IllegalArgumentException(message);
        }
    }
}
