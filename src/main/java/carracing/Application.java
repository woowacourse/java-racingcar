package carracing;

import carracing.controller.RacingGameController;
import carracing.view.input.ConsoleInputView;
import carracing.view.output.ConsoleOutputView;

public class Application {
	public static void main(String[] args) {
		RacingGameController racingGameController = new RacingGameController(new ConsoleInputView(),
			new ConsoleOutputView());
		racingGameController.init();
		racingGameController.play();
	}
}
