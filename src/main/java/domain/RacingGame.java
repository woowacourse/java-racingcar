package domain;

import domain.engine.Engine;
import domain.engine.RandomMovingEngine;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<Name> carNames) {
        Engine engine = new RandomMovingEngine();
        List<Car> collect = carNames.stream()
                .map(name -> new Car(name, engine))
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
