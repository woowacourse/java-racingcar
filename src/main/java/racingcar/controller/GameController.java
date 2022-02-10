package racingcar.controller;

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

    private String[] carNames;
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

    private void start() {
        outputView.printResultMessage();
        for (int i = 0; i <tryCount; i++) {
            carController.moveCars();
            outputView.printResult(carController.getCars());
        }
    }

    public String[] createCarNames() {
        while(true) {
            String[] carNames = trim(split(inputView.inputCarNames()));
            try {
                CarNamesValidator.validateCarNames(carNames);
                return carNames;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] split(String carNames) {
        return carNames.split(CAR_NAMES_SPLIT_REGEX);
    }

    private String[] trim(String[] carNames) {
        for (String carName : carNames) {
            carName.trim();
        }
        return carNames;
    }

    public int createTryCount() {
        String inputTryCount;
        do {
            inputTryCount = inputView.inputTryCount();
        } while(!TryCountValidator.isValidated(inputTryCount));
        return Integer.parseInt(inputTryCount);
    }

}
