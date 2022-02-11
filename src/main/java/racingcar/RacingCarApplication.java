package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
	public static void main(String[] args) {


		CarRepository carRepository = new CarRepository();
		RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
		CarController game = new CarController(carRepository, randomMovingStrategy);

		game.initGame();
		game.playGame();
		game.turnOffGame();

	}
}
