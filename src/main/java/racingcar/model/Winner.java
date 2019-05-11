package racingcar.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winner {
    private final RacingCars racingCars;

    public Winner(final RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public List<String> getWinnerNames() {
        return racingCars.getCarNames();
    }

    public Winner getWinners() {
        Car maxPositionCar = racingCars.getMaxPositionCar();
        List<Car> racingCar = racingCars.getRacingCars();
        return new Winner(new RacingCars(racingCar.stream()
                .filter(car -> car.isSamePositionCar(maxPositionCar))
                .collect(Collectors.toList())));
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
