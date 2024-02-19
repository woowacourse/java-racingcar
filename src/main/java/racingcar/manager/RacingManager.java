package racingcar.manager;

import racingcar.controller.RacingController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingManager {
    private InputView createInputView() {
        return new ConsoleInputView();
    }

    private OutputView createOutputView() {
        return new ConsoleOutputView();
    }

    public RacingController createRacingController() {
        return new RacingController(createInputView(), createOutputView());
    }
}
