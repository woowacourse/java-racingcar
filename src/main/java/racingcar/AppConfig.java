package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.controller.picker.NumberPicker;
import racingcar.controller.picker.RandomNumberPicker;
import racingcar.view.input.InputView;
import racingcar.view.input.reader.ConsoleReader;
import racingcar.view.input.reader.Reader;
import racingcar.view.output.OutputView;

public class AppConfig {

	private static final AppConfig instance = new AppConfig();

	public final Reader reader;
	public final OutputView outputView;
	public final InputView inputView;
	public final NumberPicker numberPicker;
	public final RacingCarController racingCarController;

	private AppConfig() {
		this.reader = new ConsoleReader();
		this.outputView = new OutputView();
		this.inputView = new InputView(reader);
		this.numberPicker = new RandomNumberPicker();
		this.racingCarController = new RacingCarController(numberPicker, inputView, outputView);
	}

	public static AppConfig getInstance() {
		return instance;
	}

}
