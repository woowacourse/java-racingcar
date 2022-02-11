package racingCar;

import racingCar.controller.RacingCarsController;

public class Application {
	public static void main(String[] args) {
		RacingCarsController controller = new RacingCarsController();
		controller.requestNames();
		controller.requestCount();
		controller.startGame();
		controller.endGame();
	}
}
