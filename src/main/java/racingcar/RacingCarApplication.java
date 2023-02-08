package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.GameManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

	public static void main(String[] args) {
		GameManager gameManager = new GameManager(
			new InputView(),
			new OutputView(),
			new Cars());

		gameManager.playGame();
	}
}