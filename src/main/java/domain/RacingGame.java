package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<Name> carNames) {
        List<Car> collect = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.cars = new Cars(collect);
    }

    public void moveCars() {
        cars.moveCars();
    }

    public Cars decideWinners() {
        return cars.getWinners();
    }

    public Cars getCars() {
        return cars;
    }
}
