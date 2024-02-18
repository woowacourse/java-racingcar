package domain;

import dto.RacingStatus;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final Cars cars;
    private final Count count;
    private final RandomPowerGenerator randomPowerGenerator;

    public RacingCarGame(Cars cars, Count count, RandomPowerGenerator randomPowerGenerator) {
        this.cars = cars;
        this.count = count;
        this.randomPowerGenerator = randomPowerGenerator;
    }

    public void start() {
        List<RacingStatus> racingStatuses = new ArrayList<>();
        for (int i = 0; i < count.getValue(); i++) {
            int randomPower = randomPowerGenerator.generate();
            RacingStatus racingStatus = cars.race(randomPower);
            racingStatuses.add(racingStatus);
        }
    }
}
