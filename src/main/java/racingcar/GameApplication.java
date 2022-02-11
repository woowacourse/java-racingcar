package racingcar;

import racingcar.controller.GameController;

public class GameApplication {

	public static void main(String[] args) {
		AppConfig appConfig = AppConfig.getInstance();
		GameController gameController = appConfig.gameController;
		gameController.run();
	}

}
