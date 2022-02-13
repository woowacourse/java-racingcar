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
        this.outputView = new OutputViewImpl();
        this.reader = new ConsoleReader();
        this.inputView = new InputViewImpl(reader);
        this.numberPicker = new RandomNumberPicker();
        this.gameService = new GameServiceImpl(numberPicker);
        this.gameController = new GameControllerImpl(gameService, inputView, outputView);
    }

    public static AppConfig getInstance() {
        return instance;
    }

}
