package carracinggame.controller;

import carracinggame.util.StringUtils;
import carracinggame.view.InputView;
import carracinggame.view.OutputView;
import carracinggame.domain.CarNames;

public class CarNamesController {

    public String[] getCarNames() {
        OutputView.printEnterCarNames();
        String input = InputView.getInput();
        return createCarNames(input);
    }

    public String[] createCarNames(String input) {
        try {
            CarNames.checkBlank(input);
        } catch (IllegalArgumentException e) {
            OutputView.printNameBlankError();
            return getCarNames();
        }
        return makeCarNames(input);
    }

    private String[] makeCarNames(String input) {
        String[] carNames = StringUtils.splitCarNames(input);
        carNames = StringUtils.trimCarNames(carNames);
        return checkCarNames(carNames);
    }

    private String[] checkCarNames(String[] carNames) {
        for (int idx = 0; idx < carNames.length; idx++) {
            checkCarName(carNames[idx]);
        }
        return carNames;
    }

    private void checkCarName(String carName) {
        try {
            CarNames.checkRightLength(carName);
        } catch (IllegalArgumentException e) {
            OutputView.printNameLengthError();
            getCarNames();
        }
    }
}