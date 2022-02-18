package racingcar.controller;

import racingcar.model.score.ScoreBoard;
import racingcar.service.CarService;

import java.util.List;

public class CarController {
    private final CarService carService;

    public CarController() {
        this.carService = new CarService();
    }

    public void createCars(List<String> names) {
        carService.createCars(names);
    }

    public void moveCars(int iteration) {
        carService.moveCars(iteration);
    }

    public List<ScoreBoard> findGameScoreBoard() {
        return carService.findScoreBoard();
    }

    public List<String> findWinners() {
        return carService.findWinners();
    }
}
