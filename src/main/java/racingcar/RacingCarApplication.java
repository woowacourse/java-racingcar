package racingcar;

import racingcar.domain.CarMovement;
import racingcar.domain.Cars;
import racingcar.domain.GameManager;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

	public static void main(String[] args) {
		final InputView inputView = new InputView();
		final OutputView outputView = new OutputView();
		final NumberGenerator numberGenerator = new RandomNumberGenerator();
		final CarMovement carMovement = new CarMovement(numberGenerator);
		final Cars cars = new Cars();

		final GameManager gameManager = new GameManager(inputView, outputView, carMovement, cars);

		gameManager.playGame();
	}
}