package config;

import controller.RacingGameController;
import view.InputView;
import view.MessageResolver;
import view.OutputView;

public class Config {

    private final RacingGameController racingGameController;

    public Config() {
        racingGameController = this.createRacingGameController();
    }

    public RacingGameController racingGameController() {
        return this.racingGameController;
    }

    private RacingGameController createRacingGameController() {
        return new RacingGameController(createInputView(), createOutputView());
    }

    private InputView createInputView() {
        return new InputView();
    }

    private OutputView createOutputView() {
        return new OutputView(createMessageResolver());
    }

    private MessageResolver createMessageResolver() {
        return new MessageResolver();
    }
}
