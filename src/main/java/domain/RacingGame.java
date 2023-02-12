package domain;

import java.util.Collections;
import java.util.List;

public class RacingGame {

    private final NumberGenerator numberGenerator;
    private RacingCars racingCars;

    public RacingGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void enrollCars(List<String> racingCarNames) {
        racingCars = new RacingCars(racingCarNames);
    }

    public void race() {
        racingCars.process(numberGenerator);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(racingCars.racingCars());
    }

    public List<String> getWinners() {
        return racingCars.findHeadCarNames();
    }
}
