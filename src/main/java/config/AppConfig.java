package config;

import controller.RacingCarController;
import view.InputView;
import view.OutputView;

public class AppConfig {

    public static RacingCarController config() {
        return new RacingCarController(inputView(), outputView());
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
