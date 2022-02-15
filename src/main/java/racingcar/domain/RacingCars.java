package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars() {
        racingCars = new ArrayList<>();
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void join(String[] validCarNames) {
        for (String validCarName : validCarNames) {
            racingCars.add(RacingCar.generateRacingCar(validCarName));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public RacingCar getRacingCarMaxPosition() {
        return racingCars.stream().max(Comparator.comparingInt(RacingCar::getPosition)).get();
    }
}
