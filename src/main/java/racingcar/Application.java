package racingcar;

import racingcar.controller.RacingCarsController;

public class Application {
	public static void main(String[] args) {
		RacingCarsController racingCarsController = new RacingCarsController();
		racingCarsController.run();
	}
}
