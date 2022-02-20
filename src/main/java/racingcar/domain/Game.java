package racingcar.domain;

import java.util.List;

import racingcar.domain.strategy.MovePredicate;

public class Game {
    private static final MovePredicate MOVE_PREDICATE = new MovePredicate();

    private final Cars cars;
    private int count;

    public Game(List<Car> cars, int count) {
        this.cars = new Cars(cars);
        this.count = count;
    }

    public void play() {
        cars.moveCars(MOVE_PREDICATE);
        count--;
    }

    public List<Car> getWinners() {
        return cars.matchPosition(cars.getMaxPosition());
    }

    public Cars getCars() {
        return cars;
    }

    public boolean isEnd() {
        return count <= 0;
    }
}
