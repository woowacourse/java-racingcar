package racingcar.controller;

import java.util.Map;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final CarService carService;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private int tryCount;

    public RacingcarController(CarService carService) {
        this.carService = carService;
    }

    public void run() {
        start();
        play();
        finish();
    }

    private void start() {
        initializeCarNames();
        initializeTryCount();
    }

    private void initializeCarNames() {
        try {
            outputView.printNameInput();
            carService.makeCars(inputView.readCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initializeCarNames();
        }
    }

    private void initializeTryCount() {
        try {
            outputView.printCountInput();
            tryCount = inputView.readTryCount();
            carService.validateCountInput(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initializeTryCount();
        }
    }

    private void play() {
        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            Map<String, Integer> roundResult = carService.runRound();
            outputView.printRoundResult(roundResult);
            outputView.printNewLine();
        }
    }

    private void finish() {
        outputView.printRoundResult(carService.finishRound());
        outputView.printWinners(carService.finishGame());
    }
}
