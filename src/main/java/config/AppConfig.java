package config;

import controller.Controller;
import view.InputView;
import view.OutputView;

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
