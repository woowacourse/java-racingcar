package racingcar.domain;

import java.util.List;

import racingcar.domain.strategy.MovePredicate;
import racingcar.domain.util.CarFactory;

public class Game {
    private static final MovePredicate MOVE_PREDICATE = new MovePredicate();
    private static final String COUNT_END_ERROR = "[ERROR] 이미 정해진 횟수만큼 진행되었습니다.";

    private final Cars cars;
    private int count;

    public Game(List<Car> cars, int count) {
        this.cars = new Cars(cars);
        this.count = count;
    }

    public static Game of(String carNames, int count) {
        return new Game(CarFactory.of(carNames), count);
    }

    public void play() {
        if (isEnd()) {
            throw new RuntimeException(COUNT_END_ERROR);
        }
        count--;
        cars.moveCars(MOVE_PREDICATE);
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
