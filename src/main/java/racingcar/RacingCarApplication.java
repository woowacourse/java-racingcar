package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.car.CarMovement;
import racingcar.domain.game.Cars;
import racingcar.domain.game.GameManager;
import racingcar.domain.number.NumberGenerator;
import racingcar.domain.number.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

	public static void main(String[] args) {
		final InputView inputView = new InputView();
		final OutputView outputView = new OutputView();
		final NumberGenerator numberGenerator = new RandomNumberGenerator();
		final CarMovement carMovement = new CarMovement(numberGenerator);
		final Cars cars = new Cars();
		final GameManager gameManager = new GameManager(carMovement, cars);
		final GameController gameController = new GameController(inputView, outputView, gameManager);

		gameController.playGame();
	}
}