package racingcar.controller;

import java.util.List;

import racingcar.model.Winner;
import racingcar.utils.validator.CarNamesValidator;
import racingcar.utils.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarController carController;

    private int tryCount;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        carController = new CarController();
    }

    public void run() {
        ready();
        start();
        result();
    }

    private void ready() {
        carController.createCars(createCarNames());
        tryCount = createTryCount();
    }

    private void start() {
        outputView.printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            carController.moveCars();
            outputView.printResult(carController.getCars());
        }
    }

    private void result() {
        Winner winner = new Winner();
        List<String> winners = winner.getWinners(carController.getCars());

        outputView.printWinners(winners);
    }

    public String[] createCarNames() {
        try {
            String[] carNames = inputView.inputCarNames();
            CarNamesValidator.validateCarNames(carNames);
            return carNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createCarNames();
        }
    }

    public int createTryCount() {
        try {
            String tryCountInput = inputView.inputTryCount();
            TryCountValidator.validateTryCount(tryCountInput);
            return Integer.parseInt(tryCountInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createTryCount();
        }
    }
}
