package racingcar.domain;

import java.util.List;

import racingcar.domain.strategy.MovePredicate;

public class Game {
    private final Cars cars;

    public Game(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public Cars play(MovePredicate movePredicate) {
        cars.moveCars(movePredicate);
        return cars;
    }

    public List<Car> getWinners() {
        return cars.matchPosition(cars.getMaxPosition());
    }

    public Cars getCars() {
        return cars;
    }
}
