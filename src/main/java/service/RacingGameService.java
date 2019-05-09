package service;

import model.Car;
import model.GameResult;
import model.RacingGame;

import java.util.List;

public class RacingGameService {
    List<Car> cars;
    RacingGame racingGame;
    GameResult gameResult;

    RacingGameService(List<Car> cars) {
        this.cars = cars;
        racingGame = new RacingGame();
        gameResult = new GameResult();
    }

    public List<Car> run() {
        racingGame.run(this.cars);
        return cars;
    }
}
