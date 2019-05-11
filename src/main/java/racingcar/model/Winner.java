package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winner {
    private final RacingCars racingCars;

    public Winner(final RacingCars racingCars) {
        this.racingCars = racingCars.getWinnerCars();
    }

    public List<String> getWinnerCarNames() {
        return racingCars.getCarNames();
    }

    private RacingCars getWinnerRacingCars() {
        List<Car> cars = racingCars.getRacingCars();
        for (Car car : cars) {

        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return Objects.equals(racingCars, winner.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
