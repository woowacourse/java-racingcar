package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.view.input.InputView;
import racingcar.view.input.reader.ConsoleReader;
import racingcar.view.input.reader.Reader;
import racingcar.view.output.OutputView;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    public final GameController gameController;
    public final GameService gameService;
    public final InputView inputView;
    public final OutputView outputView;
    public final Reader reader;

    private AppConfig() {
        this.reader = initReader();
        this.outputView = initOutputView();
        this.inputView = initInputView(reader);
        this.gameService = initGameService();
        this.gameController = initGameController(gameService, inputView, outputView);
    }

    public static AppConfig getInstance() {
        return APP_CONFIG;
    }

    private OutputView initOutputView() {
        return new OutputView();
    }

    private Reader initReader() {
        return new ConsoleReader();
    }

    private InputView initInputView(final Reader reader) {
        return new InputView(reader);
    }

    private GameService initGameService() {
        return new GameService();
    }

    private GameController initGameController(final GameService gameService,
                                              final InputView inputView, final OutputView outputView) {
        return new GameController(gameService, inputView, outputView);
    }

}
