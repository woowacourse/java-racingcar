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
        return cars.getTotalResult(tryCount, randomNumberGenerator);
    }
}
