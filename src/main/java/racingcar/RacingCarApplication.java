package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.controller.RandomNumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.reader.ConsoleReader;

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
