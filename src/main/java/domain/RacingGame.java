package domain;

public class RacingGame {
    private final Count count;
    private final Cars cars;
    private final RandomMovementGenerator randomMovementGenerator;

    public RacingGame(Count count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        this.count = count;
        this.cars = cars;
        this.randomMovementGenerator = randomMovementGenerator;
    }

    public static RacingGame of(Count count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        return new RacingGame(count, cars, randomMovementGenerator);
    }

    public RaceResult race() {
        return new RaceResult(cars.move(randomMovementGenerator, count));
    }
}
