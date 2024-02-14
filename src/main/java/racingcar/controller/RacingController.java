package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(
            final InputView inputView,
            final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


}
