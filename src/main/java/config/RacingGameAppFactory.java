package config;

import application.RacingGameApplication;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.InputViewForRetry;
import view.OutputView;

public class RacingGameAppFactory {

    public RacingGameApplication generateApp() {
        return new RacingGameApplication(initInputView(), initOutputView(), initNumberGenerator());
    }

    private InputViewForRetry initInputView() {
        return new InputViewForRetry(new InputView());
    }

    private OutputView initOutputView() {
        return new OutputView();
    }

    private NumberGenerator initNumberGenerator() {
        return new RandomNumberGenerator();
    }
}
