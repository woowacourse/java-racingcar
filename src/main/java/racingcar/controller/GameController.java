package racingcar.controller;

import racingcar.utils.validator.CarNamesValidator;
import racingcar.utils.validator.TryCountValidator;
import racingcar.view.InputView;

public class GameController {
    private static final String CAR_NAMES_SPLIT_REGEX = ",";

    private final InputView inputView;

    private String[] carNames;
    private int tryCount;

    public GameController() {
        inputView = new InputView();
    }

    public void run() {
        carNames = createCarNames();
        tryCount = createTryCount();
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
