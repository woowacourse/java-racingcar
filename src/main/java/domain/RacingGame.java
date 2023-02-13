package domain;

import java.util.Collections;
import java.util.List;

public class RacingGame {

    private static final int POWER_VALUE_MIN = 0;
    private static final int POWER_VALUE_MAX = 9;

    private final NumberGenerator powerValueGenerator;
    private RacingCars racingCars;

    public RacingGame() {
        this.powerValueGenerator = new RandomNumberGenerator(POWER_VALUE_MIN, POWER_VALUE_MAX);
    }

    public void enrollCars(List<String> racingCarNames) {
        racingCars = new RacingCars(racingCarNames);
    }

    public void race() {
        racingCars.process(powerValueGenerator);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(racingCars.racingCars());
    }

    public List<String> getWinnerNames() {
        return racingCars.findHeadCarNames();
    }
}
