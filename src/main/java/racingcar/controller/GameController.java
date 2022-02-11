package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.model.Winner;
import racingcar.utils.validator.CarNamesValidator;
import racingcar.utils.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private static final String CAR_NAMES_SPLIT_REGEX = ",";

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
        String[] carNames;
        do {
            carNames = trim(split(inputView.inputCarNames()));
        } while (!CarNamesIsValidated(carNames));
        return carNames;
    }

    private String[] split(final String carNames) {
        return carNames.split(CAR_NAMES_SPLIT_REGEX);
    }

    private String[] trim(final String[] carNames) {
        return Arrays.stream(carNames)
            .map(String::trim)
            .toArray(String[]::new);
    }

    private boolean CarNamesIsValidated(final String[] carNames) {
        try {
            CarNamesValidator.validateCarNames(carNames);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int createTryCount() {
        String inputTryCount;
        do {
            inputTryCount = inputView.inputTryCount();
        } while (!tryCountIsValidated(inputTryCount));
        return Integer.parseInt(inputTryCount);
    }

    private boolean tryCountIsValidated(final String inputValue) {
        try {
            TryCountValidator.validatePattern(inputValue);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
