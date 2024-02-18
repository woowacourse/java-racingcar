package domain;

import utils.PowerGenerator;

import java.util.stream.IntStream;

public class RacingGame {
    private final PowerGenerator powerGenerator;
    private final CarGroup carGroup;
    private final Attempts attempts;

    public RacingGame(final CarGroup carGroup, final Attempts attempts, final PowerGenerator powerGenerator) {
        this.carGroup = carGroup;
        this.attempts = attempts;
        this.powerGenerator = powerGenerator;
    }

    public void race() {
        final int numberOfAttempts = attempts.numberOfAttempts();
        IntStream.range(0, numberOfAttempts).forEach(i -> moveCars());
    }

    private void moveCars() {
        carGroup.getAllCars().forEach(car -> {
            final int power = powerGenerator.getNumber();
            car.move(power);
        });
    }
}
