package racingcar.controller;

import racingcar.model.ScoreBoard;
import racingcar.service.CarService;

import java.util.List;

public class CarController {
    private static final String CAR_NAMES_DUPLICATE_ERROR_MESSAGE = "중복된 자동차 이름이 입력됐습니다.";
    private static final String CAR_NAME_DELIMITER = ",";
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
