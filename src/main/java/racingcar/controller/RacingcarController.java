package racingcar.controller;

import racingcar.service.CarService;

public class RacingcarController {

    private final CarService carService;

    public RacingcarController(CarService carService) {
        this.carService = carService;
    }

    public void start() {
        carService.initializeService();
    }
}
