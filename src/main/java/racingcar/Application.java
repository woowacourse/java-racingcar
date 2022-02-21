package racingcar;

import racingcar.controller.RacingCarsController;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
	public static void main(String[] args) {
		Input inputView = new Input();
		Output outputView = new Output();
		RacingCarsController racingCarsController = new RacingCarsController(inputView, outputView);
		racingCarsController.run();
	}
}
