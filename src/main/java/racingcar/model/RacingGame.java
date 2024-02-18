package racingcar.model;

public class RacingGame {

    private final TryCount tryCount;
    private final Cars cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(TryCount tryCount, Cars cars, RandomNumberGenerator randomNumberGenerator) {
        this.tryCount = tryCount;
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public TotalResult run() {
        TotalResult totalResult = new TotalResult();
        for (int i = 0; i < tryCount.getCount(); i++) {
            totalResult.addResult(cars.makeCarsMove(randomNumberGenerator));
        }
        return totalResult;
    }
}
