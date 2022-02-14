package racingcar;

import racingcar.controller.CarController;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;

public class RacingCarApplication {

	private static CarController game;
	private static CarRepository carRepository;
	private static InputView inputView;

	public static void main(String[] args) {
		CarController game = injectDependency();

		game.initGame();
		game.playGame();
		game.showWinners();
		game.end();
	}

	private static CarController injectDependency() {
		inputView = new InputView();
		carRepository = new CarRepository();
		game = new CarController(carRepository, inputView);
		return game;
	}
}
