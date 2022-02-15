package racingcar;

import racingcar.controller.RacingController;

public class ApplicationMain {
	public static void main(String[] args) {
		RacingController racingController = new RacingController();
		racingController.createCarsByUserInput();
		racingController.run();
	}
}
