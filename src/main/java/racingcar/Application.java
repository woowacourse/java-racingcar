package racingcar;

import racingcar.controller.RacingCarsController;

public class Application {
	public static void main(String[] args) throws Exception {
		RacingCarsController controller = new RacingCarsController();
		controller.requestCarsName();
		controller.requestCount();
		controller.startGame();
		controller.endGame();
	}
}
