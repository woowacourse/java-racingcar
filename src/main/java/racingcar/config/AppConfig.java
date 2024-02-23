package racingcar.config;

import racingcar.controller.Controller;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public static Controller config() {
        return new Controller(inputView(), outputView());
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
