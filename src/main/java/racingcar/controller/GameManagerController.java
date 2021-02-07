package racingcar.controller;

import racingcar.view.InputView;

public class GameManagerController {
    public void run() {
        String[] carNames = getInputCarNames();
        int roundCount = getInputRoundCount();
    }

    private String[] getInputCarNames() {
        String input = InputView.inputCarNames();
        String[] carNames = input.split(",");
        return carNames;
    }

    private int getInputRoundCount() {
        return InputView.inputRoundCount();
    }
}
