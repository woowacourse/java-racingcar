package domain;

import console.OutputView;
import utils.RandomPowerGenerator;

public class Race {

    private final Cars cars;
    private final TryCount tryCount;

    public Race(final Cars cars, final TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void startRace(final RandomPowerGenerator randomPowerGenerator) {
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.moveAll(randomPowerGenerator);
            OutputView.printCurrentRacingStatus(cars);
        }
    }
}
