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
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		NumberGenerator numberGenerator = new RandomNumberGenerator();
		CarMovement carMovement = new CarMovement(numberGenerator);
		Cars cars = new Cars();

		GameManager gameManager = new GameManager(
			inputView,
			outputView,
			carMovement,
			cars);

		gameManager.playGame();
	}
}