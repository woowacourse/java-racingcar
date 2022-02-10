package racingcar.controller;

import java.util.Arrays;

import racingcar.view.InputView;

public class GameController {
    private static final String CAR_NAMES_SPLIT_REGEX = ",";

    private final InputView inputView;

    public GameController() {
        inputView = new InputView();
    }

    public void run() {
         createCarNames();
    }

    public String[] createCarNames() {
        return trim(split(inputView.inputCarNames()));
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
}
