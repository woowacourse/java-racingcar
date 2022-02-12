package racingcar.controller;

import racingcar.util.InputValidator;

import static racingcar.view.InputView.scanCarNames;
import static racingcar.view.InputView.scanTryCount;

public class InputController {
    private static final String SPLIT_REGEX = ",";

    public String[] getUserCarNames() throws RuntimeException {
        String userCarText = scanCarNames();
        return carSplit(userCarText);
    }

    public int getUserTryCount() throws RuntimeException {
        String userTryCount = scanTryCount();
        int tryCount = toInt(userTryCount);
        InputValidator.validateNegativeTryCount(tryCount);
        return tryCount;
    }

    public String[] carSplit(String cars) throws RuntimeException {
        for (String carName : cars.split(SPLIT_REGEX)) {
            InputValidator.validateName(carName);
        }
        return cars.split(SPLIT_REGEX);
    }

    public int toInt(String scanNumber) throws RuntimeException {
        InputValidator.validateTryCount(scanNumber);
        return Integer.parseInt(scanNumber);
    }
}
