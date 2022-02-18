package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.car.strategy.CustomMoveStrategy;
import racingcar.domain.car.strategy.MoveStrategy;
import racingcar.service.GameService;
import racingcar.view.input.InputView;
import racingcar.view.input.reader.CustomReader;
import racingcar.view.input.reader.Reader;
import racingcar.view.output.OutputView;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    public final GameController gameController;
    public final CustomMoveStrategy moveStrategy;
    public final GameService gameService;
    public final InputView inputView;
    public final OutputView outputView;
    public final CustomReader reader;

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

    private CustomReader initReader() {
        return new CustomReader();
    }

    private InputView initInputView(final Reader reader, final OutputView outputView) {
        return new InputView(reader, outputView);
    }

    private CustomMoveStrategy initMoveStrategy() {
        return new CustomMoveStrategy();
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
