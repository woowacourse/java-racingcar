package racingcar;

import racingcar.controller.CarController;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		CarRepository carRepository = new CarRepository();

		CarController game = new CarController(carRepository, inputView, outputView);
		game.play();
	}
}
