public class RacingGame {
    private final int count;
    private Cars cars;
    private RandomMovementGenerator randomMovementGenerator;


    public RacingGame(int count, Cars cars) {
        this.count = count;
        this.cars = cars;
    }


    public static RacingGame fromCount(int count) {
        return new RacingGame(count, Cars.fromEmpty());
    }

    public static RacingGame fromEmpty() {
        return new RacingGame(0, Cars.fromEmpty());
    }

    public static RacingGame of(int count, Cars cars) {
        return new RacingGame(count, cars);
    }

    public void play() {
        for (int i = 0; i < count; i++) {
            cars.move(randomMovementGenerator);
        }
    }
}
