package domain;

import java.util.ArrayList;
import java.util.List;

public class GameProgressService {
    private GameMovingStrategy strategy;

    public GameProgressService(GameMovingStrategy strategy) {
        this.strategy = strategy;
    }

    public GameResult initGameResult(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return new GameResult(cars);
    }

    public GameResult raceByRound(GameResult gameResult) {
        List<Car> cars = gameResult.getCars();

        for (Car car : cars) {
            car.move(strategy.getMovingNum());
        }

        return new GameResult(cars);
    }
}
