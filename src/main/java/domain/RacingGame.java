package domain;

public class RacingGame {
    private final int count;
    private Cars cars;
    private RandomMovementGenerator randomMovementGenerator;


    public RacingGame(int count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        this.count = count;
        this.cars = cars;
        this.randomMovementGenerator = randomMovementGenerator;
    }


    public static RacingGame fromCount(int count) { // TODO 일단 넣어놨음
        return new RacingGame(count, Cars.fromEmpty(), new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    public static RacingGame fromEmpty() { // TODO 일단 넣어놨음
        return new RacingGame(0, Cars.fromEmpty(), new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    public static RacingGame of(int count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        return new RacingGame(count, cars, randomMovementGenerator);
    }

}
