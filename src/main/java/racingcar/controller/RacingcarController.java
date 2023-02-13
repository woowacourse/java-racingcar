package racingcar.controller;

import java.util.List;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final CarService carService;
    private int tryCount;

    public RacingcarController(CarService carService) {
        this.carService = carService;
    }

    public void start() {
        carService.initializeCars();
        readNameInput();
        readCountInput();
    }

    private void readNameInput() {
        try {
            OutputView.printNameInput();
            List<String> carNames = splitCarNames(InputView.readCarNames());
            carService.makeCar(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            carService.initializeCars();
            readNameInput();
        }
    }

    private List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(","));
    }

    private void readCountInput() {
        try {
            OutputView.printCountInput();
            tryCount = InputView.readTryCount();
            carService.validateNegativeCount(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCountInput();
        }
    }

    public void run() {
        OutputView.printResultMessage();
        for (int i = 1; i <= tryCount; i++) {
            carService.runRound(i);
            OutputView.printRoundResult(carService.getCarsStatus());
        }
    }

    public void finish() {
        OutputView.printRoundResult(carService.getCarsStatus());
        OutputView.printWinners(carService.findWinner());
    }
}
