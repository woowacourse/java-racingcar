package racingcar;

import racingcar.service.RacingCarGame;
import racingcar.service.StepGenerator;

public class Application {
	public static void main(String[] args) {
		RacingCarGame racingCarGame = new RacingCarGame(new StepGenerator());
		racingCarGame.run();
	}
}
