package config;

import controller.RacingGameController;
import service.RaceGameService;
import view.InputMapper;
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
        return new RacingGameController(createInputView(), createOutputView(), raceGameService(), inputMapper());
    }

    private InputView createInputView() {
        return new InputView(inputMapper());
    }

    private InputMapper inputMapper() {
        return new InputMapper();
    }

    private OutputView createOutputView() {
        return new OutputView(createMessageResolver());
    }

    private MessageResolver createMessageResolver() {
        return new MessageResolver();
    }

    private RaceGameService raceGameService() {
        return new RaceGameService();
    }

}
