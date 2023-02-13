package service;

import domain.Cars;
import java.util.List;
import java.util.Map;
import strategy.MovingStrategy;

public class RacingGame {

    private final Cars cars;
    private final MovingStrategy movingStrategy;

    public RacingGame(Cars cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public Map<String, Integer> playSingleRound() {
        cars.moveCars(movingStrategy);
        return cars.getTotalStatus();
    }

    public List<String> getWinners() {
        return cars.findWinners();
    }
}
