package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final CarService carService;

    public RacingcarController(CarService carService) {
        this.carService = carService;
    }

    public void start() {
        initializeCarNames();
        initializeTryCount();
    }

    public void initializeCarNames() {
        try {
            OutputView.printNameInput();
            carService.validateNameInput(InputView.readCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initializeCarNames();
        }
    }

    public void initializeTryCount() {
        try {
            OutputView.printCountInput();
            carService.validateCountInput(InputView.readTryCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initializeTryCount();
        }
    }

    public void run() {
        carService.runService();
    }

    public void finish() {
        carService.finishService();
    }
}
