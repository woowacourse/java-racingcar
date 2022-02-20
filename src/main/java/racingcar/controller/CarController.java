package racingcar.controller;

import racingcar.model.score.ScoreBoard;
import racingcar.service.CarService;
import racingcar.service.GameScoreBoardService;

import java.util.List;

public class CarController {
    private final CarService carService;
    private final GameScoreBoardService gameScoreBoardService;

    public CarController() {
        this.carService = new CarService();
        gameScoreBoardService = new GameScoreBoardService();
    }

    public void createCars(List<String> names) {
        carService.createCars(names);
    }

    public void moveCars(int iteration) {
        for (int i = 0; i < iteration; i++) {
            carService.moveCars();
            gameScoreBoardService.addScoreBoard(i, carService.findCarDtos());
        }
    }

    public List<ScoreBoard> findGameScoreBoard() {
        return gameScoreBoardService.findScoreBoard();
    }

    public List<String> findWinners() {
        return gameScoreBoardService.findWinners();
    }
}
