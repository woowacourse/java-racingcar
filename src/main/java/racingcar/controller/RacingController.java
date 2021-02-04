package racingcar.controller;

import racingcar.domain.Names;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void start() {
        try {
            OutputView.enterCarNames();
            Names names = InputView.getNames();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
