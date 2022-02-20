package racingcar.controller;

import racingcar.util.InputValidator;

public class InputController {

    public String[] getUserCarNames(final String userCarText) throws RuntimeException {
        return splitCar(userCarText);
    }

    private String[] splitCar(final String cars) throws RuntimeException {
        String[] carNames = cars.split(",");
        for (String carName : carNames) {
            InputValidator.validateName(carName);
        }
        return carNames;
    }

    public int getUserTryCount(final String userTryCount) throws RuntimeException {
        return toInt(userTryCount);
    }

    private int toInt(final String scanNumber) throws RuntimeException {
        return InputValidator.validateTryCount(scanNumber);
    }
}
