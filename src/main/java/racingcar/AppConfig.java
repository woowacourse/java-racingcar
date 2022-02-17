package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.service.picker.NumberPicker;
import racingcar.service.picker.RandomNumberPicker;
import racingcar.view.input.InputView;
import racingcar.view.input.reader.ConsoleReader;
import racingcar.view.input.reader.Reader;
import racingcar.view.output.OutputView;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    public final GameController gameController;
    public final GameService gameService;
    public final NumberPicker numberPicker;
    public final InputView inputView;
    public final Reader reader;
    public final OutputView outputView;

    private AppConfig() {
        this.outputView = initOutputView();
        this.reader = initReader();
        this.inputView = initInputView(reader);
        this.numberPicker = initNumberPicker();
        this.gameService = initGameService(numberPicker);
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

    private NumberPicker initNumberPicker() {
        return new RandomNumberPicker();
    }

    private GameService initGameService(final NumberPicker numberPicker) {
        return new GameService(numberPicker);
    }

    private GameController initGameController(final GameService gameService,
                                              final InputView inputView,
                                              final OutputView outputView) {
        return new GameController(gameService, inputView, outputView);
    }

}
