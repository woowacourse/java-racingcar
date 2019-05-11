package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final RacingCars racingCars;

    public Winner(final RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars getWinners() {
        Car maxPositionCar = racingCars.getMaxPositionCar();
        List<Car> racingCar = racingCars.getRacingCars();
        return new RacingCars(racingCar.stream()
                .filter(car -> car.isSamePositionCar(maxPositionCar))
                .collect(Collectors.toList()));
    }
}
