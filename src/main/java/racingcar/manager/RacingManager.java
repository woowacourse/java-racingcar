package racingcar.manager;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingManager {
    private InputView createInputView() {
        return new InputView();
    }

    private OutputView createOutputView() {
        return new OutputView();
    }

    public RacingController createRacingController() {
        return new RacingController(createInputView(), createOutputView());
    }
}
