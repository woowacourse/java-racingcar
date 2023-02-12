package config;

import application.RacingGameApplication;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.InputViewProxy;
import view.OutputView;

public class RacingGameAppFactory {

    public static RacingGameApplication generate() {
        return new RacingGameApplication(initInputView(), initOutputView(), initNumberGenerator());
    }

    private static InputView initInputView() {
        return new InputViewProxy(new InputView());
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }

    private static NumberGenerator initNumberGenerator() {
        return new RandomNumberGenerator();
    }
}
