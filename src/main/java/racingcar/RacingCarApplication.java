package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.controller.picker.RandomNumberPicker;
import racingcar.view.input.InputView;
import racingcar.view.input.reader.ConsoleReader;
import racingcar.view.output.OutputView;

public class RacingCarApplication {

	public static void main(String[] args) {
		RacingCarController controller = new RacingCarController(
			new RandomNumberPicker(),
			new InputView(new ConsoleReader()),
			new OutputView()
		);
		controller.run();
	}
}
