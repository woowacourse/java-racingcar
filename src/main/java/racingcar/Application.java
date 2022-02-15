package racingcar;

import racingcar.controller.RacingCarsController;

public class Application {
	public static void main(String[] args) {
		RacingCarsController controller = new RacingCarsController();
		controller.start();
	}
}
