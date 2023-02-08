package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {

	private final InputView inputView;
	private final OutputView outputView;
	private final Cars cars;
	private final GameRound gameRound;

	public GameManager(InputView inputView, OutputView outputView, Cars cars, GameRound gameRound) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.cars = cars;
		this.gameRound = gameRound;
	}

	public void createCars() {
		inputView.inputCarName()
			.getCarNames()
			.forEach(cars::generateCar);
	}
}
