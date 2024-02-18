package domain;

public class RacingGame {
    private Count count;
    private final MovementGenerator randomMovementGenerator;

    private RacingGame(final Count count, final MovementGenerator randomMovementGenerator) {
        this.count = count;
        this.randomMovementGenerator = randomMovementGenerator;
    }

    public static RacingGame of(Count count, MovementGenerator randomMovementGenerator) {
        return new RacingGame(count, randomMovementGenerator);
    }

    public boolean canRun() {
        return count.isExits();
    }

    public void playTurn(Cars cars) {
        cars.move(randomMovementGenerator);
        count.increase();
    }
}
