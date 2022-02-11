package racingcar;

import racingcar.controller.CarController;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
	public static void main(String[] args) {

		CarRepository carRepository = new CarRepository();
		CarController game = new CarController(carRepository);

		game.initGame();
		game.playGame();
		game.turnOffGame();

	}
}
