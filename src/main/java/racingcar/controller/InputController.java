package racingcar.controller;

import racingcar.util.InputValidator;

import static racingcar.view.InputView.scanCarNames;
import static racingcar.view.InputView.scanTryCount;

public class InputController {
    public String[] getUserCarNames(final String userCarText) throws RuntimeException {
        return splitCar(userCarText);
    }

    public int getUserTryCount(final String userTryCount) throws RuntimeException {
        return toInt(userTryCount);
    }

    private String[] splitCar(final String cars) throws RuntimeException {
        String[] carNames = cars.split(",");
        for (String carName : carNames) {
            InputValidator.validateName(carName);
        }
        return carNames;
    }

    private int toInt(final String scanNumber) throws RuntimeException {
        InputValidator.validateTryCount(scanNumber);
        return Integer.parseInt(scanNumber);
    }
}
