package config;

import controller.RacingGameController;
import view.InputView;
import view.MessageResolver;
import view.OutputView;

public class Config {
    public RacingGameController racingGameController() {
        return new RacingGameController(inputView(), outputView());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView(messageResolver());
    }

    public MessageResolver messageResolver() {
        return new MessageResolver();
    }

}
