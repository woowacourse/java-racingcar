package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.GameControllerImpl;
import racingcar.service.GameService;
import racingcar.service.GameServiceImpl;
import racingcar.service.picker.NumberPicker;
import racingcar.service.picker.RandomNumberPicker;
import racingcar.view.input.InputView;
import racingcar.view.input.InputViewImpl;
import racingcar.view.input.reader.ConsoleReader;
import racingcar.view.input.reader.Reader;
import racingcar.view.output.OutputView;
import racingcar.view.output.OutputViewImpl;

public class AppConfig {

    private static final AppConfig instance = new AppConfig();

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
        return instance;
    }

    private OutputView initOutputView() {
        return new OutputViewImpl();
    }

    private Reader initReader() {
        return new ConsoleReader();
    }

    private InputView initInputView(Reader reader) {
        return new InputViewImpl(reader);
    }

    private NumberPicker initNumberPicker() {
        return new RandomNumberPicker();
    }

    private GameService initGameService(NumberPicker numberPicker) {
        return new GameServiceImpl(numberPicker);
    }

    private GameController initGameController(GameService gameService, InputView inputView, OutputView outputView) {
        return new GameControllerImpl(gameService, inputView, outputView);
    }

}
