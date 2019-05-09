package racingcar.controller;

import racingcar.view.InputView;

public class RacingGameController {

    public String requestCarList() {
        return InputView.inputCarList();
    }
}
