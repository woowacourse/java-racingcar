package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.service.CarMoveGenerator;

public class Application {
	public static void main(String[] args) {
		RacingCarGame racingCarGame = new RacingCarGame(new CarMoveGenerator());
		racingCarGame.run();
	}
}
