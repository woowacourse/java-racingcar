package service;

import domain.Cars;
import java.util.List;
import strategy.MovingStrategy;

public class RacingGame {

    private final String WINNER_NAME_DELIMITER = ", ";
    private final Cars cars;
    private final MovingStrategy movingStrategy;

    public RacingGame(Cars cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public List<String> playSingleRound() {
        cars.moveCars(movingStrategy);
        return cars.getTotalStatus();
    }

    public String getWinners() {
        List<String> winners = cars.findWinners();
        return String.join(WINNER_NAME_DELIMITER, winners);
    }
}
