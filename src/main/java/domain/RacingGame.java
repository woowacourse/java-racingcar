package domain;

import utils.Engine;

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

    public void moveCars(Engine engine) {
        cars.moveCars(engine);
    }

    public Cars decideWinners() {
        return cars.getWinners();
    }

    public Cars getCars() {
        return cars;
    }
}
