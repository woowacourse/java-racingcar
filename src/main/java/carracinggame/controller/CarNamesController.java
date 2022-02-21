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
        String[] carNames;
        try {
            CarNames.checkBlank(input);
            carNames = makeCarNames(input);
            checkCarNames(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.println(e.getMessage());
            return getCarNames();
        }
        return carNames;
    }

    private String[] makeCarNames(String input) {
        String[] carNames = StringUtils.splitCarNames(input);
        return StringUtils.trimCarNames(carNames);
    }

    private void checkCarNames(String[] carNames) throws IllegalArgumentException{
        for (String carName : carNames) {
            CarNames.checkRightLength(carName);
        }
    }
}