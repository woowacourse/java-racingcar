package racingcar;

import racingcar.controller.RacingCarController;

public class Application {

	public static void main(String[] args) {
		AppConfig appConfig = AppConfig.getInstance();
		RacingCarController gameController = appConfig.racingCarController;
		gameController.run();
	}

}
