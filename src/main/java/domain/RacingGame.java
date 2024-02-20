package domain;

import utils.PowerGenerator;
import utils.RandomPowerGenerator;

public class RacingGame {
    private final CarGroup carGroup;
    private final PowerGenerator powerGenerator;


    public RacingGame(final CarGroup carGroup) {
        this.carGroup = carGroup;
        this.powerGenerator = new RandomPowerGenerator();
    }

    RacingGame(final CarGroup carGroup, final PowerGenerator powerGenerator) {
        this.carGroup = carGroup;
        this.powerGenerator = powerGenerator;
    }

    public void moveCars() {
        carGroup.getAllCars().forEach(car -> {
            final int power = powerGenerator.getNumber();
            car.move(power);
        });
    }
}
