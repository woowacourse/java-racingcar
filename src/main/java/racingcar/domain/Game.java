package racingcar.domain;

import java.util.List;

import racingcar.domain.strategy.MovePredicate;

public class Game {
    private final Cars cars;
    private int count;

    public Game(List<Car> cars, int count) {
        this.cars = new Cars(cars);
        this.count = count;
    }

    public void play(MovePredicate movePredicate) {
        cars.moveCars(movePredicate);
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
