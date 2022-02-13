package racingcar;

import racingcar.controller.CarController;
import racingcar.repository.CarRepository;

public class RacingCarApplication {

	public static void main(String[] args) {

		CarRepository carRepository = new CarRepository();
		CarController game = new CarController(carRepository);

		game.initGame();
		game.playGame();
		game.showWinners();
		game.end();

	}
}
