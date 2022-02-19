package racingcar.domain;

import java.util.List;

import racingcar.domain.strategy.MovePredicate;

public class Game {
    private final Cars cars;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public Cars play(MovePredicate movePredicate) {
        cars.moveCars(movePredicate);
        return cars;
    }

    public List<Car> getWinners() {
        return cars.matchPosition(cars.getMaxPosition());
    }
}
