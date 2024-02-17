package domain;

public class RacingGame {
    private Count countLeft;
    private final MovementGenerator randomMovementGenerator;

    private RacingGame(final Count countLeft, final MovementGenerator randomMovementGenerator) {
        this.countLeft = countLeft;
        this.randomMovementGenerator = randomMovementGenerator;
    }

    public static RacingGame of(Count count, MovementGenerator randomMovementGenerator) {
        return new RacingGame(count, randomMovementGenerator);
    }

    public boolean canRun() {
        return countLeft.isExits();
    }

    public void playTurn(Cars cars) {
        cars.move(randomMovementGenerator);
        this.countLeft = countLeft.decrease();
    }
}
