package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.car.strategy.MoveStrategy;
import racingcar.domain.car.strategy.RandomMoveStrategy;
import racingcar.service.GameService;
import racingcar.view.input.InputView;
import racingcar.view.input.reader.ConsoleReader;
import racingcar.view.input.reader.Reader;
import racingcar.view.output.OutputView;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    public final GameController gameController;
    public final MoveStrategy moveStrategy;
    public final GameService gameService;
    public final InputView inputView;
    public final OutputView outputView;
    public final Reader reader;

    private AppConfig() {
        this.reader = initReader();
        this.outputView = initOutputView();
        this.inputView = initInputView(reader, outputView);
        this.moveStrategy = initMoveStrategy();
        this.gameService = initGameService(moveStrategy);
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

    private InputView initInputView(final Reader reader, final OutputView outputView) {
        return new InputView(reader, outputView);
    }

    private MoveStrategy initMoveStrategy() {
        return new RandomMoveStrategy();
    }

    private GameService initGameService(final MoveStrategy moveStrategy) {
        return new GameService(moveStrategy);
    }

    private GameController initGameController(final GameService gameService,
                                              final InputView inputView,
                                              final OutputView outputView) {
        return new GameController(gameService, inputView, outputView);
    }

}
