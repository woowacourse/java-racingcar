package racingcar.controller;

import racingcar.view.InputView;

import java.util.Arrays;

public class GameManagerController {
    public void run() {
        String[] carNames = getInputCarNames();
    }

    private String[] getInputCarNames() {
        String input = InputView.inputCarNames();
        String[] carNames = input.split(",");

        return carNames;
    }
}
