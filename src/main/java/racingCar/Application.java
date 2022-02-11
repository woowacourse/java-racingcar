package racingCar;

import racingCar.controller.RacingCarsController;

public class Application {
	public static void main(String[] args) {
		RacingCarsController controller = new RacingCarsController();
		controller.request();
		controller.startGame();
		controller.endGame();
	}
}
