package config;

import application.RacingGameApplication;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.InputViewProxyForRetry;
import view.OutputView;

public class RacingGameAppFactory {

    public RacingGameApplication generateApp() {
        return new RacingGameApplication(initInputView(), initOutputView(), initNumberGenerator());
    }

    private InputView initInputView() {
        return new InputViewProxyForRetry(new InputView());
    }

    private OutputView initOutputView() {
        return new OutputView();
    }

    private NumberGenerator initNumberGenerator() {
        return new RandomNumberGenerator();
    }
}
