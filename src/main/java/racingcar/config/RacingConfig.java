package racingcar.config;

import racingcar.controller.RacingManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingConfig {
    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    public RacingManager racingController() {
        return new RacingManager(inputView(), outputView());
    }
}
