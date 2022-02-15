package racingCar;

import racingCar.controller.RacingCarController;

public class Application {

	public static void main(String[] args) {
		RacingCarController racingCar = new RacingCarController();
		racingCar.start();
	}
}
