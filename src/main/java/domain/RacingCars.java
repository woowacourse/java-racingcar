package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars.addAll(racingCars);
    }

    public void moveAll() {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.move();
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
